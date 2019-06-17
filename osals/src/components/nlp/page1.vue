<template>
  <div>
    <h1 style="line-height:4px;">下面为分词标注：</h1>
    <h1 style="line-height:2px">__________Text:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data.text" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">________HanLP:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data.word_1" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">_____FoolNLTK:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data.word_2" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">standfordNLP:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data.word_3" style="width: 500px ; height: 25px"></h1>
    <h1 style="line-height:2px">___________Ansj:<input type="text"  class="qxs-ic_password qxs-icon"  v-bind:value="data.word_4" style="width: 500px ; height: 25px"></h1>
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
      //created like main function
      // this.test1();
      //test1 must be this.
      // alert(data.text)
      //Can use alert to test your code
    },
    methods:{
      test1:function () {
        let that = this
        var url = this.HOST+"/nlpwt/response"
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
