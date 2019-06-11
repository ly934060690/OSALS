<template>
  <div id="app">
  </div>
</template>
<script>
  import axios from "axios";
  export default {
    name: "app",
    data() {
      return {
        itemList: []
      }
    },
    mounted() {
      this.getData();
    },
    methods: {
      getData() {
        axios.get('/api/test.json').then(response => {
          console.log(response.data);
        }, response => {
          console.log("error");
        });
      }
    }
  }
</script>
