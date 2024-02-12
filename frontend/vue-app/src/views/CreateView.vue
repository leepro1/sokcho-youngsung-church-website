<template>
  <div class="container mt-3">
    <h1 class="display-1 text-center">회원 가입</h1>
    <form>
      <div class="mb-3 mt-3">
        <label for="username" class="form-label">이름:</label>
        <input type="text" class="form-control" :class="{ active: active.username }" id="username" placeholder="이름을 입력하세요."
          name="username" v-model="member.username">
      </div>
      <div class="mb-3 mt-3">
        <label for="email" class="form-label">이메일:</label>
        <input type="email" class="form-control" :class="{ active: active.email }" id="email" placeholder="이메일를 입력하세요."
          name="email" v-model="member.email">
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">비밀번호:</label>
        <input type="password" class="form-control" :class="{ active: active.password }" id="password"
          placeholder="비밀번호를 입력하세요." name="password" v-model="member.password">
      </div>
      <div class="d-flex">
        성별 :
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="maleRadio" name="sex" v-bind:value="male"
              v-model="member.sex">남성
            <label class="form-check-label" for="maleRadio1"></label>
          </div>
        </div>
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="femaleRadio" name="sex" v-bind:value="female"
              v-model="member.sex">여성
            <label class="form-check-label" for="femaleRadio"></label>
          </div>
        </div>
      </div>
      <div class="d-flex">
        등록 교인 입니까? :
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="churchMemberRadio1" name="isChurchMember" v-bind:value="true"
              v-model="member.isChurchMember">등록
            <label class="form-check-label" for="churchMemberRadio1"></label>
          </div>
        </div>
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="churchMemberRadio2" name="isChurchMember"
              v-bind:value="false" v-model="member.isChurchMember"> 미등록
            <label class="form-check-label" for="churchMemberRadio2"></label>
          </div>
        </div>
      </div>
    </form>
    <div class="d-flex">

      <div class="p-2 flex-fill d-grid">
        <button type="button" class="btn btn-primary" @click="save">생성</button>
      </div>
      <div class="p-2 flex-fill d-grid">
        <router-link to="/member" class="btn btn-primary">취소</router-link>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  name: 'CreateView',
  data() {
    return {
      member: { username: '', email: '', password: '', sex: '', isChurchMember: false },
      active: { username: false, email: false, password: false }
    }
  },
  methods: {
    save() {
      if (this.member.username == '') {
        this.active.username = true
        return
      } else {
        this.active.username = false
      }
      if (this.member.email == '') {
        this.active.email = true
        return
      } else {
        this.active.email = false
      }
      if (this.member.password == '') {
        this.active.password = true
        return
      } else {
        this.active.password = false
      }

      axios
        .post('http://localhost:8080/members', this.member)
        .then((response) => {
          this.$store.commit('setMember', respose.data.member)
          this.$router.push({ name: 'SelectView' })
        })
        .catch((error) => {
          console.log(error)
        })
    }
  }
}
</script>

<style scoped>.active {
  background-color: red;
}</style>