<template>
  <div class="home">
    <h1>안녕하세요 속초영성교회입니다.</h1>
    <button @click="getData">데이터 호출</button>  
  </div>
</template>

<script>
export default {
  name: 'HomeView',
  methods: {
    getData() {
      axios.get('http://localhost:8080')
        .then((response) => {
          console.log(response)
        })
        .catch((error) => {
          console.log(error)
        })
    }
  }
}
</script>
