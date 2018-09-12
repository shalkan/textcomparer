import * as mutations from './text-value-mutations';

import axios from 'axios';

export const loadTextValues= (context, payload) => {
  context.commit(mutations.SET_LOADING, true);
  axios.get('/text-value')
      .then(response => {
        if (response.status == 200) {
          context.commit(mutations.SET_TEXT_VALUES, response.data);
        }
        context.commit(mutations.SET_LOADING, false);
      }).catch((error) => {
    context.commit(mutations.SET_LOADING, false);
  });
}