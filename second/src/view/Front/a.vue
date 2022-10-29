<template>
    <div>
        <p style="margin: 0 auto">hello============>a</p>
        <div id="richText"  style="margin-top: 50px">

        </div>
        <el-button style="margin: 50px 700px" type="primary" size="medium" @click="toup">
            上传
        </el-button>
    </div>
</template>

<script>
    /*富文本编辑器*/
    import E from 'wangeditor'
    let editor;

    export default {
        name: "a",
        data(){
          return {
             content: ''
          }
        },
        created() {

        },
        mounted() {
            /*开启富文本，使用mounted渲染*/
            editor=new E("#richText");
            editor.config.uploadImgServer= 'http://localhost:8080/file/editorImg';
            editor.config.uploadFileName= 'file';
            editor.create();
        },
        methods: {
            toup(){
                /*获取富文本 的内容，转成代码格式
                *
                * editor.txt.html()
                *
                */
                alert(editor.txt.html())
            }
        }
    }
</script>

<style>

</style>