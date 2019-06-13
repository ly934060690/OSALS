<template>
  <div>
    <h3 style="line-height: 60px">
      <img src="../../assets/picture/u=2982202372,1719347959&fm=26&gp=0.jpg" height="500" width="700"/>
      <br>
      <font size="10">欢迎使用NLP系统</font>
    </h3>
    <div class="login_form" id="txt" style="line-height: 20px">
      <input type="text"  class="qxs-ic_user"  placeholder="要提交的语句" v-model="text" style="width: 600px ; height:60px">
      <br>
      <el-button class="submit_btn" @click.native="submit" type="primary" round :loading="isBtnLoading">提交</el-button>
    </div>

  </div>
</template>

<script>
  export default {
  data() {
    return {
      userName: '',
      password: '',
      isBtnLoading: false,
      str:{}
    }
  },
  created:function(){
    this.postdata()
  },
  methods:{

    }
  }
</script>

<style>

  input::-webkit-input-placeholder {
    /* placeholder颜色  */
    color: #000000;
    /* placeholder字体大小  */
    font-size: 20px;
  }
  .login_form {
    padding-top: 10%;
    padding-left: 10%;
    padding-right: 10%;
  }
  .qxs-ic_user {
   /* background: url("../assets/login/ic_user.png") no-repeat; */
    background-size: 13px 15px;
    background-position: 10%;
  }
  .qxs-ic_password {
   /* background: url("../assets/login/ic_password.png") no-repeat; */
    background-size: 13px 15px;
    background-position: 3%;
    margin-bottom: 20px;
  }
  .submit_btn {
    width: 25%;
    font-size: 25px;
    background: -webkit-linear-gradient(left, #000099, #2154FA); /* Safari 5.1 - 6.0 */
    background: -o-linear-gradient(right, #000099, #2154FA); /* Opera 11.1 - 12.0 */
    background: -moz-linear-gradient(right, #000099, #2154FA); /* Firefox 3.6 - 15 */
    background: linear-gradient(to right, #000099 , #2154FA); /* 标准的语法 */
    filter: brightness(1.4);
  }
</style>
