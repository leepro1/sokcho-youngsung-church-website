<template>
  <div class="container mt-3">
    <h1 class="display-1 text-center">사용자 수정</h1>
    <form>
      <div class="mb-3 mt-3">
        <label for="name" class="form-label">이름:</label>
        <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name" readonly
          v-model="member.username">
      </div>
      <div class="mb-3 mt-3">
        <label for="email" class="form-label">이메일:</label>
        <input type="email" class="form-control" id="email" placeholder="이메일를 입력하세요." name="email" readonly
          v-model="member.email">
      </div>
      <div class="mb-3">
        <label for="pwd" class="form-label">비밀번호:</label>
        <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요." name="pwd" v-model="member.password">
      </div>
      <div class="d-flex">
        성별 :
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="maleRadio" name="sex" value="male" v-model="member.sex">남성
            <label class="form-check-label" for="maleRadio"></label>
          </div>
        </div>
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="FemaleRadio" name="sex" value="female" v-model="member.sex">여성
            <label class="form-check-label" for="FemaleRadio"></label>
          </div>
        </div>
      </div>
      <div class="d-flex">
        등록 교인 입니까? :
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="churchMemberRadio1" name="isChurchMember"
              v-bind:value="true" v-model="member.isChurchMember">등록
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
        <button type="button" class="btn btn-primary" @click="save">수정</button>
      </div>
      <div class="p-2 flex-fill d-grid">
        <button type="button" class="btn btn-primary" @click="cancel">취소</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data() {
    return {
      member: {}
    }
  },
  created() {
    this.member = this.$store.state.member
  },
  methods: {
    save() {
      axios
      .put('http://localhost:8080/members/'+this.member.id, this.member)
      .then((response) => {
          if(response.data.state){
            this.$store.commit('setMember',this.member)    
            sessionStorage.setItem('setMember', this.base64(this.member))
            this.cancel()
          } else{
            alert(response.data.message)
          }
        })
        .catch((error) => {
          console.log(error)
        })
    },
    cancel() {
      this.$router.push({name: "SelectView"})
    },
    base64(member) {
      return window.btoa(encodeURIComponent(JSON.stringify(member)))
    }
  }
}
</script>
