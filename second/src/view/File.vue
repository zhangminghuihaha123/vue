<template>
    <div>
        <div class="mg-10">
            <el-input style="width: 200px" placeholder="请输入名称" suffix-icon="el-icon-search" v-model="name"></el-input>
            <el-button class="ml-10" type="primary" @click="getFileTo">搜索</el-button>
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
            <el-table-column prop="filename" label="文件名称" width="320"></el-table-column>
            <el-table-column prop="type" label="文件类型"></el-table-column>
            <el-table-column prop="size" label="文件大小（KB）"></el-table-column>
            <el-table-column label="预览" width="140px" align="center">
                <template slot-scope="slot">
                    <img v-if="slot.row.type === 'png' || slot.row.type === 'jpg' || slot.row.type === 'gif'" :src="slot.row.avater" style="width: 50px;height: 50px">
                    <i v-else-if="slot.row.type=== 'xlsx'" class="el-icon-document" style="font-size: 50px"></i>
                    <i v-else-if="slot.row.type=== 'mp4' || slot.row.type=== 'mp3'" class="el-icon-service" style="font-size: 50px"></i>
                    <i v-else class="el-icon-folder" style="font-size: 50px"></i>
                </template>
            </el-table-column>
            <el-table-column label="前台是否启用" width="200px" align="center">
                <template slot-scope="scope">
                    <el-switch v-model="scope.row.check" active-color="#13ce66" inactive-color="#ff4949" @change="change(scope.row)"></el-switch>
                </template>
            </el-table-column>
            <el-table-column label="下载" align="center">
                <template slot-scope="scope">
                    <el-button type="primary" @click="download(scope.row.filename)">下载</el-button>
                </template>
            </el-table-column>
            <el-table-column label="操作" align="center">
                <template slot-scope="scope">
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
                    :page-sizes="[5, 10, 20]"
                    :page-size="100"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
            </el-pagination>
        </div>

        <el-dialog title="文件信息" :visible.sync="dialogFormVisible" width="30%">
            <el-form label-width="80px"  size="small">
                   <p>文件输入</p><br><br>
                    <el-upload action="http://localhost:8080/file/upload" style="display: inline-block" class="ml-10" :show-file-list="true"
                               :on-success="importSuccess" :limit="1">
                        <img v-if="avater != null" :src="avater" class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="save">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "File",
        created() {
          this.getFileTo();
        },
        data() {
            return {
                tableData: [],
                total: 0,
                pageNum: 1,
                pageSize: 5,
                name: '',
                avater: null,
                dialogFormVisible: false
            }
        },
        methods: {
            getFileTo(){
                this.request.get('/file/get',{
                    params:{
                        pageNum: this.pageNum,
                        pageSize: this.pageSize,
                        filename: this.name
                    }
                }).then(res => {
                    this.tableData=res.data.data;
                    this.total=res.data.total;
                })
            },
            download(data){
                window.open('http://localhost:8080/file/img/'+data);
            },
            handleSizeChange(pageSize) {
                this.pageSize = pageSize;
                this.getFileTo();
            },
            handleCurrentChange(pageNUm) {
                this.pageNum = pageNUm;
                this.getFileTo();
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            opens(){
                this.dialogFormVisible=true;
            },
            importSuccess(res,file){
                console.log(res);
                this.avater=URL.createObjectURL(file.raw);
                this.$message.success("上传成功!");
            },
            save(){
                this.dialogFormVisible=false;
                this.getFileTo();
            },
            reset(){
                this.name='';
                this.getFileTo();
            },
            deletes(id){
                this.request.delete('/file/delete/'+id).then(res => {
                    this.getFileTo();
                    this.$message.success(res.data);
                })
            },
            deletebatch(){
                let ids=this.multipleSelection.map( v=> v.id);
                this.request.post('/file/delete',ids).then(res => {
                    this.getFileTo();
                    this.$message.success(res.data);
                })
            },
            change(file){
                this.request.post('/file/bol',file);
            }
        }
    }
</script>

<style>
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