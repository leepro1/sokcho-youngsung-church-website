<template>
  <div class="container mt-3">
    <h1 class="display-1 text-center">회원 목록</h1>
    <div class="btn-group">
      <a href="/member/save" class="btn btn-primary">회원 추가</a>
    </div>
    <table class="table table-hover mt-3">
      <thead class="table-dark">
        <tr>
          <th>이름</th>
          <th>이메일</th>
          <th>성별</th>
          <th>등록여부</th>
          <th>가입일</th>
        </tr>
      </thead>
      <tbody>
        <tr class="cursor-pointer" v-for="member in memberList" :key="member.id"
        @click="$event => href(member)">
          <td>{{ member.name }}</td>
          <td>{{ member.email }}</td>
          <td>{{ member.sex }}</td>
          <td>{{ member.isChurchMember }}</td>
          <td>{{ member.createdTime }}</td>
        </tr>

      </tbody>
    </table>
  </div>
</template>
    
<script>
import axios from 'axios'
import store from '@/store'
export default {
  name: "ListView",
  data() {
    return {
      memberList: []
    }
  }, 
  created() {
    this.getMemberList()
  },
  methods: {
    getMemberList() {
      axios
        .get('http://localhost:8080/admin/members')
        .then((response) => {
          this.memberList = response.data.result
        })
        .catch((error) => {
          console.log(error)
        })
    },
    href(member) {
      store.commit('setMember',member)
      this.$router.push({name: "SelectView"})
    }
  }
}

</script>
<style scoped>
tbody>tr {
  cursor: pointer;
}
</style>