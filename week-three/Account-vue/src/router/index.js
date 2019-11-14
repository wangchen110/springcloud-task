import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import operation from '@/components/operation'
import AccountList from '@/components/AccountList'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'operation',
      component: operation
    },
    {
      path: '/list',
      name: 'AccountList',
      component: AccountList
    }
  ]
})
