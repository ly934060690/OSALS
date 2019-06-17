<template>
  <div>
    <h1 style="line-height:4px">下面为实体抽取：</h1>
    <h1 style="line-height:8px">
      <textarea  class="textarea0" v-bind:value="data.name1" ></textarea></h1>
    <h1 style="line-height:8px">
    <h style="position: relative; left: -50px">
      <p style="line-height:0px ; position:relative; left:40px ; white-space:pre">***1                                                          ***2</p>
    <textarea  class="textarea1" v-bind:value="data.name1" ></textarea></h>

    <h style="position: relative; right: -50px">
      <textarea  class="textarea2" v-bind:value="data.name2" ></textarea></h>

    </h1>
    <h1 style="line-height:8px">
    <h style="position: relative; left:  -50px">
      <p style="line-height:0px ; position:relative; left:40px ; white-space:pre">***3                                                          ***4</p>
    <textarea  class="textarea3" v-bind:value="data.name3" ></textarea></h>

    <h style="position: relative; right: -50px">
    <textarea  class="textarea4" v-bind:value="data.name4" ></textarea></h>
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
        var url = this.HOST+"/user/response"
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
    width: 950px ;
    height: 100px ;
    border: double ;
    border-color: #c9ffaf;
    border-width: 5px ;

  }
  .textarea1{
    width: 400px ;
    height: 200px ;
    border: inset ;
    border-color: aqua ;
    border-width: 10px ;

  }
  .textarea2{
    width: 400px ;
    height: 200px ;
    border: double ;
    border-color: aqua ;
    border-width: 10px ;
    margin-right: 5px;
  }
  .textarea3{
    width: 400px ;
    height: 200px ;
    border: double ;
    border-width: 10px ;
    border-color: aqua;
  }
  .textarea4{
    width: 400px ;
    height: 200px ;
    border: outset ;
    border-color: aqua ;
    border-width: 10px ;
  }
</style>
