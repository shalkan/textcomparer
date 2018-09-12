import Vue from 'vue';
import VueRouter from 'vue-router';

import TextValueList from './text-value/text-value-list.vue';

Vue.use(VueRouter);

const routes = [
  {path: '/', component: TextValueList}
];

const router = new VueRouter({
  routes
});

export default router;