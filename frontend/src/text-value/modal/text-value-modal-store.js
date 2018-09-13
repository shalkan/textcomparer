import Vue from 'vue';
import Vuex from 'vuex';

import * as mutations from './text-value-modal-mutations';
import * as actions from './text-value-modal-actions';

Vue.use(Vuex);

export default {
  namespaced: true,
  state: {
    loading: true,
    showModal: false,
    model: {},
    modelHistoryLoading: false,
    modelUpdateHistoryList: [],
    showComparePanel: false,
    modelToCompare: {},
    compareResult: {}
  },
  mutations: {
    [mutations.SET_LOADING](state, loading = false) {
      state.loading = !!loading;
    },
    [mutations.SET_SHOW_MODAL](state, showModal = false) {
      state.showModal = !!showModal;
    },
    [mutations.SET_MODEL](state, payload = {}) {
      state.model = payload;
    },
    [mutations.SET_MODEL_HISTORY_LOADING](state, payload = false) {
      state.modelHistoryLoading = !!payload;
    },
    [mutations.SET_MODEL_UPDATE_HISTORY_LIST](state, payload = []) {
      state.modelUpdateHistoryList = payload;
    },
    [mutations.SET_SHOW_COMPARE_PANEL](state, payload = false) {
      state.showComparePanel = !!payload;
    },
    [mutations.SET_MODEL_TO_COMPARE](state, payload = {}) {
      state.modelToCompare = payload;
    },
    [mutations.SET_COMPARE_RESULT](state, payload = {}) {
      state.compareResult = payload;
    }
  },
  actions
};