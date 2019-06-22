<template>
  <div style="line-height: 40px">

      <img src="../../assets/picture/u=2982202372,1719347959&fm=26&gp=0.jpg" height="500" width="700"/>
      <br>
      <font size="10">欢迎使用NLP系统</font>
      <br>



      <textarea id="txt" type="text"  class="qxs-ic_user" placeholder="要提交的语句" v-model="postData" style="width: 700px ; height:200px ; font-size: 20px">
      </textarea><br>
      <el-button class="submit_btn"  @click.native="message" type="primary" round :loading="isBtnLoading">提交</el-button>

    <!-- @click.native you can invoke function by click this button -->
    <!--  ps: this from submit data is also json property -->
    <!-- ps: sometime you should take care for the content-type of your data -->
  </div>
</template>

<script>
  export default {
    data() {
      return {
        postData:'',
        isBtnLoading: false,
      }
    },
    created:function(){
    },

    methods: {
      message: function () {
        /* you can bind this from by this id(txt) */
        let content = document.getElementById("txt");
        let postData = {
          "text": content.value,
          /* here is transferring value of text */
        }
        alert('您要提交的数据为：' + postData.text)
        this.submits1(postData)
        /* invoking function(submits)
         *  if you change this order you may be meet the data's value miss
         *  or you can put this function into that(submit) function
         */
        this.submits2(postData);
        this.submits3(postData);
        this.submits4(postData);
        this.submits5(postData);
      },
      submits1: function (postData) {
        this.$axios({
          method: 'post',
          url: this.HOST + '/nlperg/request',
          data: postData
          /* parameter match  */
        }).then((res) => {
          console.log(res.data)
        }).catch(err => {
          console.log(err)
        })
      },
      submits2: function (postData) {
        this.$axios({
          method: 'post',
          url: this.HOST + '/nlpke/request',
          data: postData
          /* parameter match  */
        }).then((res) => {
          console.log(res.data)
        }).catch(err => {
          console.log(err)
        })
      },
      submits3: function (postData) {
        this.$axios({
          method: 'post',
          url: this.HOST + '/nlpae/request',
          data: postData
          /* parameter match  */
        }).then((res) => {
          console.log(res.data)
        }).catch(err => {
          console.log(err)
        })
      },
      submits4: function (postData) {
        this.$axios({
          method: 'post',
          url: this.HOST + '/nlpdr/request',
          data: postData
          /* parameter match  */
        }).then((res) => {
          console.log(res.data)
        }).catch(err => {
          console.log(err)
        })
      },
      submits5: function (postData) {
        this.$axios({
          method: 'post',
          url: this.HOST + '/nlptc/request',
          data: postData
          /* parameter match  */
        }).then((res) => {
          console.log(res.data)
        }).catch(err => {
          console.log(err)
        })
      }
    }
  }
</script>

<style>
  /*  these are styles for just this page */
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
  .submit_text {
    /* you can set the logo for this from !
    background: url("../assets/login/ic_user.png") no-repeat; */
    background-size: 13px 15px;
    background-position: 10%;
  }

  .submit_btn {
    width: 25%;
    font-size: 25px;
    background: -webkit-linear-gradient(left, #000099, #2154FA); /* Safari 5.1 - 6.0 */
    background: -o-linear-gradient(right, #000099, #2154FA); /* Opera 11.1 - 12.0 */
    background: -moz-linear-gradient(right, #000099, #2154FA); /* Firefox 3.6 - 15 */
    background: linear-gradient(to right, #000099 , #2154FA); /* Standard grammar */
    filter: brightness(1.4);
  }
</style>
