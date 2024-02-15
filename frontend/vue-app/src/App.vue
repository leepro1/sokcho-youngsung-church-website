<template>
  <router-view/>
</template>

<script>
export default{
  created() {
    const member = sessionStorage.getItem('setMember')
    if(member) {
      this.$store.commit('setMember', JSON.parse(member))
    }
  },
  methods: {
    base64(member) {
      return JSON.parse(decodeURIComponent(window.atob(member)))
    }
  }
}
</script>
