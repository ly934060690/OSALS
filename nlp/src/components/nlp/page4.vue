<template>
  <div>
    <h1 style="line-height:4px">下面为关键词提取：</h1>
    <h1 style="line-height:8px">
      <textarea  class="textarea0" v-bind:value="data.text" ></textarea></h1>
    <h1 style="line-height:8px">
      <h style="position: relative; left: -50px">
        <p style="line-height:0px ; position:relative; left:30px ; white-space:pre">HanLP                                                                                                           FoolNlp</p>
        <textarea  class="textarea1" v-bind:value="data.word_1"></textarea></h>

      <h style="position: relative; right: -50px">
        <textarea  class="textarea2" v-bind:value="data.word_2" ></textarea></h>

    </h1>
    <h1 style="line-height:8px">
      <h style="position: relative; left:  -50px">
        <p style="line-height:0px ; position:relative; left:30px ; white-space:pre">StanfordNlp                                                                                                  AnsjNlp</p>
        <textarea  class="textarea3" v-bind:value="data.word_3" ></textarea></h>

      <h style="position: relative; right: -50px">
        <textarea  class="textarea4" v-bind:value="data.word_4" ></textarea></h>
    </h1>
    <el-button class="login_btn" @click.native="test1" type="primary" round :loading="isBtnLoading">刷新</el-button>
    <!--the @click.native is to call this function-->
    <!--the username from data1.username must keep up with the json property-->
    <router-view/>
  </div>
</template>

<script type="text/javascript">
  import axios from 'axios';
  export default {
    data() {
      return {
        //It like the statement of variables
        data:{},
      }
    },
    created() {
    },
    methods:{
      test1:function () {
        let that = this
        var url = this.HOST+"/nlpke/response"
        //if you want to change the value of HOST ,please go to /osals/config/index.js/->module.exports->dev->proxyTable->target
        this.$axios.get(url)
          .then(function (res) {
            that.data = res.data;
            //this res.data is from the server's response
            console.log("成功获得data1");
          })
          .then(function (res) {
            console.log(res);
          })
      }
    }

  }
</script>

<style>
  .textarea0{
    width: 1150px ;
    height: 100px ;
    border: double ;
    border-color: #c9ffaf;
    border-width: 5px ;
    font-size: 20px;
  }
  .textarea1{
    width: 500px ;
    height: 200px ;
    border: inset ;
    border-color: aqua ;
    border-width: 10px ;
    font-size: 20px;
  }
  .textarea2{
    width: 500px ;
    height: 200px ;
    border: double ;
    border-color: aqua ;
    border-width: 10px ;
    margin-right: 5px;
    font-size: 20px;
  }
  .textarea3{
    width: 500px ;
    height: 200px ;
    border: double ;
    border-width: 10px ;
    border-color: aqua;
    font-size: 20px;
  }
  .textarea4{
    width: 500px ;
    height: 200px ;
    border: outset ;
    border-color: aqua ;
    border-width: 10px ;
    font-size: 20px;
  }
</style>
