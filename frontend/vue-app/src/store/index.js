import { createStore } from 'vuex'

export default createStore ({
    state() {
        return {
            member: {}
        }
    },
    mutations: {
        setMember(state, value) {
            state.member = value
        }
    }
})