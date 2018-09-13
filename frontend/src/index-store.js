import Vue from 'vue';
import Vuex from 'vuex';

import textValueStore from './text-value/text-value-store';
import textValueModalStore from './text-value/modal/text-value-modal-store'

import * as textValueMutations from './text-value/text-value-mutations';
import * as textValueModalMutations from './text-value/modal/text-value-modal-mutations'

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    [textValueMutations.MAIN_NAMESPACE]: textValueStore,
    [textValueModalMutations.MAIN_NAMESPACE]: textValueModalStore
  }
});

