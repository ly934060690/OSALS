import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import ServiceHall from '@/components/ServiceHall'
import Management from '@/components/Management'
import User from '@/components/User'
import Personnel from '@/components/Personnel'
import Alarm from '@/components/Alarm'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/components/ServiceHall',
      name: 'ServiceHall',
      component: ServiceHall
    }, {
      path: '/components/Management',
      name: 'Management',
      component: Management
    },
    {
      path: '/components/User',
      name: 'User',
      component: User
    },{
      path: '/components/Personnel',
      name: 'Personnel',
      component: Personnel
    },{
      path: '/components/Alarm',
      name: 'Alarm',
      component: Alarm
    }
  ]
})
