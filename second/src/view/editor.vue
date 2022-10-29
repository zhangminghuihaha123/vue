<template>
    <div>
        <div class="mg-10">
            <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="titleName"></el-input>
            <el-button class="ml-10" type="primary" @click="getEditor">搜索</el-button>
            <el-button type="warning" @click="reset">重置</el-button>
        </div>
        <div class="mg-10">
            <el-button type="primary" class="ml-10" @click="opens">增加<i class="el-icon-bottom"></i></el-button>
            <el-popconfirm
                    class="ml-10"
                    confirm-button-text='好的'
                    cancel-button-text='我再想想'
                    icon="el-icon-info"
                    icon-color="red"
                    title="您确定删除吗？"
                    @confirm="deletebatch">
                <el-button type="danger" slot="reference">批量删除<i class="el-icon-remove-outline"></i></el-button>
            </el-popconfirm>
        </div>

        <el-table :data="tableData" border stripe :header-cell-class-name="'headerBg'" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="id" label="ID" width="140" fixed></el-table-column>
            <el-table-column prop="title" align="center" label="商品信息" width="320"></el-table-column>
            <el-table-column label="图片预览" width="140px" align="center">
                <template slot-scope="slot">
                    <img :src="slot.row.avater" style="width: 50px;height: 50px">
                </template>
            </el-table-column>
            <el-table-column label="文章内容" width="240px" align="center">
                <template slot-scope="slot">
                    <el-button type="primary" size="medium" @click="view(slot.row.test)">查看</el-button>
                </template>
            </el-table-column>
            <el-table-column prop="time" align="center" label="创建时间" width="320"></el-table-column>
            <el-table-column label="操作" align="center">test
                <template slot-scope="scope">
                    <el-button type="warning" @click="edit(scope.row)">编辑 <i class="el-icon-edit"></i></el-button>
                    <el-popconfirm
                            class="ml-10"
                            confirm-button-text='好的'
                            cancel-button-text='我再想想'
                            icon="el-icon-info"
                            icon-color="red"
                            title="您确定删除吗？"
                            @confirm="deletes(scope.row.id)">
                        <el-button type="danger" slot="reference">删除<i class="el-icon-remove-outline"></i></el-button>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>

        <div style="padding: 10px 0">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[10, 15, 20]"
                    :page-size="100"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
            </el-pagination>
        </div>

        <el-dialog title="商品信息" :visible.sync="dialogFormVisible" width="50%">
            <el-form label-width="80px"  size="small">
                <el-form-item label="商品名称">
                    <el-input v-model="form.title"></el-input>
                </el-form-item>
                <el-form-item label="商品图片">
                    <el-upload
                            class="avatar-uploader"
                            action="http://localhost:8080/file/upload"
                            :show-file-list="true"
                            :limit="1"
                            :on-success="handleAvatarSuccess">
                        <img v-if="form.avater !== null && form.avater !== ''" :src="form.avater" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </el-form-item>
                <el-form-item label="商品介绍">
                    <div id="richText">

                    </div>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="save">确 定</el-button>
            </div>
        </el-dialog>

        <el-dialog title="内容" :visible.sync="dialogFormVisible2" width="50%">
             <el-card>
                 <div v-html="content"></div>
             </el-card>
        </el-dialog>
    </div>
</template>

<script>
    /*富文本编辑器*/
    import E from 'wangeditor'
    let editor;

    export default {
        name: "editor",
        data(){
            return{
                tableData: [],
                dialogFormVisible: false,
                dialogFormVisible2:false,
                form: {
                    avater: ""
                },
                test: '',
                imgURL: '',
                content: '',
                titleName: "",
                total: 0,
                pageNum:  1,
                pageSize: 10
            }
        },
        created() {
           this.getEditor();
        },
        mounted() {

        },
        methods: {
            getEditor(){
              this.request.get('/edit/get',{params:{
                      titleName: this.titleName,
                      pageNum: this.pageNum,
                      pageSize: this.pageSize
                  }}).then(res => {
                  this.tableData=res.data.data;
                  this.total=res.data.total;
              })
            },
            view(test){
                 this.content=test;
                 this.dialogFormVisible2=true;
            },
            opens(){
                this.dialogFormVisible=true;
                /*开启富文本，使用mounted渲染*/
                this.$nextTick(() => {
                    editor=new E("#richText");
                    editor.config.uploadImgServer= 'http://localhost:8080/file/editorImg';
                    editor.config.uploadFileName= 'file';
                    editor.create();
                })
                editor.txt.html('');
            },
            handleAvatarSuccess(res,file) {
                this.form.avater = URL.createObjectURL(file.raw);
                this.test=JSON.stringify(file.name);
                this.imgURL=this.form.avater;
            },
            save(){
                this.form.test=editor.txt.html();
                this.form.avater=this.test;
                this.request.post('/edit/save',this.form).then(res =>{
                    if(res.code==='200'){
                        this.form.avater= this.imgURL;
                        this.$message.success("上传成功");
                        this.dialogFormVisible=false;
                        this.getEditor();
                    }else {
                        this.$message.error("上传失败！请重试");
                    }
                })
            },
            deletes(id){
                this.request.delete('/edit/delete/'+id).then(res =>{
                    if(res.code==='200'){
                        this.$message.success("删除成功!");
                        this.getEditor();
                    }
                })
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            deletebatch(){
                let ids=this.multipleSelection.map( v=> v.id);
                this.request.post('/edit/deletes',ids).then(res=>{
                    if(res.code==='200'){
                        this.$message.success("删除成功!");
                        this.getEditor();
                    }
                })
            },
            reset(){
                this.titleName='';
                this.getEditor();
            },
            edit(row){
                this.dialogFormVisible=true;
                /*开启富文本，使用mounted渲染*/
                this.$nextTick(() => {
                    editor=new E("#richText");
                    editor.config.uploadImgServer= 'http://localhost:8080/file/editorImg';
                    editor.config.uploadFileName= 'file';
                    editor.create();
                })
                this.form=row;
                editor.txt.html(row.test);
            },
            handleSizeChange(pageSize){
                this.pageSize=pageSize;
                this.load();
            },
            handleCurrentChange(pageNUm){
                this.pageNum=pageNUm;
                this.load();
            }
        }
    }
</script>

<style scoped>
    .avatar-uploader {
        text-align: center;
        padding-bottom: 10px;
    }
    .avatar-uploader .el-upload {
        border: 1px dashed #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;
    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
    .avatar-uploader-icon {
        font-size: 28px;
        color: #8c939d;
        width: 138px;
        height: 138px;
        line-height: 138px;
        text-align: center;
    }
    .avatar {
        width: 138px;
        height: 138px;
        display: block;
    }
</style>