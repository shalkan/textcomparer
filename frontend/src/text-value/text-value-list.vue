<template>
    <div v-loading.body="loading">
        <div>
            <h2>Text values</h2>
            <el-card>
                <el-button @click="addTextValue">Add</el-button>
                <el-table :data="textValues" style="width: 100%" stripe>
                    <el-table-column prop="id" label="Id"></el-table-column>
                    <el-table-column prop="textValue" label="Value"></el-table-column>
                    <el-table-column prop="audWhenCreate" label="Created">
                        <template slot-scope="scope">
                            <p>{{scope.row.audWhenCreate | formatDateTime}}</p>
                        </template>
                    </el-table-column>
                    <el-table-column prop="audWhen" label="Updated">
                        <template slot-scope="scope">
                            <p>{{scope.row.audWhen | formatDateTime}}</p>
                        </template>
                    </el-table-column>
                    <el-table-column label="Actions">
                        <template slot-scope="scope">
                            <el-tooltip effect="dark" content="Edit" placement="top">
                                <el-button size="mini" type="primary"
                                           @click="editTextValue(scope.row)">Edit
                                </el-button>
                            </el-tooltip>
                            <el-tooltip effect="dark" content="Delete" placement="top">
                                <el-button size="mini" type="primary"
                                           @click="deleteTextValue(scope.row)">Delete
                                </el-button>
                            </el-tooltip>
                        </template>
                    </el-table-column>
                </el-table>
            </el-card>
        </div>
        <TextValueModal/>
    </div>
</template>

<script>
  import Vue from 'vue';
  import {mapState} from 'vuex';
  import ElementUI from 'element-ui';
  import 'element-ui/lib/theme-chalk/index.css';
  import store from '../index-store';
  import router from '../index-router';

  import moment from 'moment';
  import lang from 'element-ui/lib/locale/lang/en'
  import locale from 'element-ui/lib/locale'

  import * as mutations from './text-value-mutations';
  import * as textValueModalMutations from './modal/text-value-modal-mutations';
  import TextValueModal from './modal/text-value-modal.vue';

  Vue.use(ElementUI);
  locale.use(lang);

  export default Vue.component('TextValueList', {
    computed: mapState('textValueList/', ['loading', 'textValues']),
    created: () => {
      store.dispatch('textValueList/loadTextValues');
    },
    data() {
      return {}
    },
    store,
    router,
    methods: {
      addTextValue() {
        store.dispatch(textValueModalMutations.NAMESPACE + 'showModal');
      },
      editTextValue(textValue) {
        store.dispatch(textValueModalMutations.NAMESPACE + 'openModalForEdit', textValue.id);
      },
      deleteTextValue(textValue) {
        store.dispatch(mutations.NAMESPACE + 'deleteTextValue', textValue.id);
      }
    },
    filters: {
      formatDateTime: (date) => {
        if (!date) return '';
        return moment(date).format('DD.MM.YYYY HH:mm:ss');
      }
    }
  })
</script>
