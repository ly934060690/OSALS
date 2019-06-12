<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view/>
    <Test></Test>
    <Date1></Date1>
    <LeftNa></LeftNa>
  </div>
</template>

<script>
  import Test from './components/test.vue'
  import Date1 from './components/date.vue'
  import LeftNa from './components/LeftNavigation'

  export default {
    components:{
      Test,
      Date1,
      LeftNa,
    },
    name: 'App'
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
