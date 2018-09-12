import Vue from 'vue';
import Vuex from 'vuex';

import * as mutations from './text-value-mutations';
import * as actions from './text-value-actions';

Vue.use(Vuex);

export default {
  namespaced: true,
  state: {
    loading: true,
    textValues: []
  },
  mutations: {
    [mutations.SET_LOADING](state, loading = false) {
      state.loading = !!loading;
    },
    [mutations.SET_TEXT_VALUES](state, textValues = []) {
      state.textValues = textValues;
    }
  },
  actions
};