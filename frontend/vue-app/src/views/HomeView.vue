<template>
  <div class="home">
    <button @click="getMemberList">memberList</button>  
  </div>
  <div class="home">
    <button @click="getMember(id)">memberDetail</button>  
  </div>
  <div class="home">
    <button @click="createMember">createMember</button>  
  </div>
  <div class="home">
    <button @click="updateMember(id)">updateMember</button>  
  </div>
  <div class="home">
    <button @click="deleteMember(id)">deleteMember</button>  
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'HomeView',
  data:()=>({
      id : 6,
      memberFormDto : { id : 6, email : "qwer@qwer", password:"1234", username:"가나다", sex: "male", isChurchMember:false }
  }),
  methods: {
    getMemberList() {
      axios
        .get('http://localhost:8080/admin/members')
        .then((response) => {
          console.log(response)
        })
        .catch((error) => {
          console.log(error)
        })
    },
    getMember(id) {
      axios
        .get('http://localhost:8080/members/'+id)
        .then((response) => {
          console.log(response)
        })
        .catch((error) => {
          console.log(error)
        })
    },
    createMember() {
      axios
        .post('http://localhost:8080/members', this.memberFormDto)
        .then((response) => {
          console.log(response)
        })
        .catch((error) => {
          console.log(error)
        })
    },
    updateMember(id) {
      axios
        .put('http://localhost:8080/members/'+id, this.memberFormDto)
        .then((response) => {
          console.log(response)
        })
        .catch((error) => {
          console.log(error)
        })
    },
    deleteMember(id) {
      axios
        .delete('http://localhost:8080/members/'+id)
        .then((response) => {
          console.log(response)
        })
        .catch((error) => {
          console.log(error)
        })
    },
  }
}
</script>
