import axios from 'axios';

import * as mutations from './text-value-modal-mutations';
import * as textValueListMutations from '../text-value-mutations';

import TextComparer from '../../util/text-comparer';

export const showModal = (context, payload) => {
  context.commit(mutations.SET_MODEL);
  context.commit(mutations.SET_SHOW_MODAL, true);
}

export const closeModal = (context, payload) => {
  context.commit(mutations.SET_SHOW_MODAL, false);
  context.commit(mutations.SET_MODEL);
  context.commit(mutations.SET_MODEL_UPDATE_HISTORY_LIST);
  context.commit(mutations.SET_MODEL_TO_COMPARE);
  context.commit(mutations.SET_COMPARE_RESULT);
  context.commit(mutations.SET_SHOW_COMPARE_PANEL, false);
}

export const openModalForEdit = (context, payload) => {
  if (!!payload) {
    context.dispatch('showModal');
    context.dispatch('loadTextValueUpdateHistory', payload);
    context.commit(mutations.SET_LOADING, true);
    axios.get('/text-value/' + payload)
        .then(response => {
          if (response.status == 200) {
            context.commit(mutations.SET_MODEL, response.data);
          }
          context.commit(mutations.SET_LOADING, false);
        }).catch(error => {
      console.error(error);
      context.commit(mutations.SET_LOADING, false);
    })
  }
  //TODO: implement else{ show message}
}

export const saveTextValue = (context, payload) => {
  context.commit(mutations.SET_LOADING, true);
  axios.post('/text-value', payload)
      .then(response => {
        if (response.status == 200) {
          context.dispatch('closeModal');
          context.dispatch(textValueListMutations.NAMESPACE + 'loadTextValues', {}, {root: true});
        }
        context.commit(mutations.SET_LOADING, false);
      }).catch(error => {
    console.error(error);
    context.commit(mutations.SET_LOADING, false);
  })
}

export const updateTextValue = (context, payload) => {
  context.commit(mutations.SET_LOADING, true);
  axios.put('/text-value', payload)
      .then(response => {
        if (response.status == 200) {
          context.dispatch('closeModal');
          context.dispatch(textValueListMutations.NAMESPACE + 'loadTextValues', {}, {root: true});
        }
        context.commit(mutations.SET_LOADING, false);
      }).catch(error => {
    console.error(error);
    context.commit(mutations.SET_LOADING, false);
  })
}

export const loadTextValueUpdateHistory = (context, payload) => {
  context.commit(mutations.SET_MODEL_HISTORY_LOADING, true);
  axios.get('/text-value/history', {
    params: {
      textValueId: payload
    }
  }).then(response => {
        if (response.status == 200) {
          context.commit(mutations.SET_MODEL_UPDATE_HISTORY_LIST, response.data);
        }
        context.commit(mutations.SET_MODEL_HISTORY_LOADING, false);
      }).catch((error) => {
    context.commit(mutations.SET_MODEL_HISTORY_LOADING, false);
  });
}

export const showComparePanel = (context, payload) => {
  context.commit(mutations.SET_MODEL_TO_COMPARE, payload.modelToCompare);
  context.commit(mutations.SET_COMPARE_RESULT,
      TextComparer.compareText(payload.modelToCompare.textValue, payload.currentModel.textValue)
  );
  context.commit(mutations.SET_SHOW_COMPARE_PANEL, true);
}

export const closeComparePanel = (context, payload) => {
  context.commit(mutations.SET_MODEL_TO_COMPARE);
  context.commit(mutations.SET_COMPARE_RESULT);
  context.commit(mutations.SET_SHOW_COMPARE_PANEL, false);
}