import Vue from 'vue';
import Vuex from 'vuex';

import textValueStore from './text-value/text-value-store';

import * as textValueMutations from './text-value/text-value-mutations';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    [textValueMutations.MAIN_NAMESPACE]: textValueStore
  }
});

