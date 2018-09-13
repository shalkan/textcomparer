<template>
    <el-dialog :visible="showModal"
               :show-close="false" :close-on-click-modal="false" :close-on-press-escape="false"
               width="90%">
        <div v-loading.body="modelHistoryLoading" v-show="!showComparePanel">
            <div v-loading.body="loading">
                <el-form :model="model" ref="requestForm" label-position="right">
                    <el-form-item label="Text value">
                        <el-input type="textarea" :rows="10" v-model="model.textValue"
                                  placeholder="Enter text value"/>
                    </el-form-item>
                </el-form>
            </div>

            <h3>Update history</h3>
            <span v-show="!model.id">History is empty</span>
            <el-table :data="modelUpdateHistoryList" style="width: 100%" stripe v-show="!!model.id">
                <el-table-column prop="textValue" label="Value"></el-table-column>
                <el-table-column prop="whenEdit" label="Updated">
                    <template slot-scope="scope">
                        <p>{{scope.row.whenEdit | formatDateTime}}</p>
                    </template>
                </el-table-column>
                <el-table-column label="Actions">
                    <template slot-scope="scope">
                        <el-tooltip effect="dark" content="Compare with current version" placement="top" v-show="scope.row.whenEdit != model.audWhen">
                            <el-button size="mini" type="primary"
                                       @click="openComparePanel(scope.row)">Compare
                            </el-button>
                        </el-tooltip>
                    </template>
                </el-table-column>
            </el-table>
        </div>

        <div v-show="showComparePanel">
            <el-row>
                <el-col :span="12">
                    <h3>Version from {{modelToCompare.whenEdit | formatDateTime}}</h3>
                    <div class="compare-text-panel" v-html="compareResult.sourceValue"></div>
                </el-col>
                <el-col :span="12">
                    <h3>Current version ({{model.audWhen | formatDateTime}})</h3>
                    <div class="compare-text-panel" v-html="compareResult.modifiedValue"></div>
                </el-col>
            </el-row>
            <el-row>
                <el-button size="mini" type="primary"
                           @click="closeComparePanel()">Back
                </el-button>
            </el-row>

        </div>

        <span slot="footer" class="dialog-footer">
            <el-button v-show="!showComparePanel" @click="saveModel">Save</el-button>
            <el-button @click="closeModal">Close</el-button>
        </span>
    </el-dialog>

</template>
<style>
    .compare-text-panel {
        border: 1px solid black;
        border-radius: 5px;
        padding: 5px;
        margin: 10px;
    }
</style>

<script>
  import Vue from 'vue';
  import {mapState} from 'vuex';
  import ElementUI from 'element-ui';
  // import 'element-ui/lib/theme-chalk/index.css';
  import store from '../../index-store';

  import moment from 'moment';
  import * as mutations from './text-value-modal-mutations';

  Vue.use(ElementUI);

  export default Vue.component('TextValueModal', {
    created: () => {
    },
    data() {
      return {};
    },
    computed: mapState({
      loading: state => state[mutations.MAIN_NAMESPACE].loading,
      showModal: state => state[mutations.MAIN_NAMESPACE].showModal,
      model: state => state[mutations.MAIN_NAMESPACE].model,
      modelHistoryLoading: state => state[mutations.MAIN_NAMESPACE].modelHistoryLoading,
      modelUpdateHistoryList: state => state[mutations.MAIN_NAMESPACE].modelUpdateHistoryList,
      showComparePanel: state => state[mutations.MAIN_NAMESPACE].showComparePanel,
      modelToCompare: state => state[mutations.MAIN_NAMESPACE].modelToCompare,
      compareResult: state => state[mutations.MAIN_NAMESPACE].compareResult
    }),
    store,
    methods: {
      saveModel() {
        let model = store.state[mutations.MAIN_NAMESPACE].model;
        store.dispatch(mutations.NAMESPACE + (!model.id ? 'saveTextValue' : 'updateTextValue'), model);
      },
      closeModal() {
        store.dispatch(mutations.NAMESPACE + 'closeModal');
      },
      openComparePanel(modelToCompare) {
        store.dispatch(mutations.NAMESPACE + 'showComparePanel', {
          currentModel: store.state[mutations.MAIN_NAMESPACE].model,
          modelToCompare
        });
      },
      closeComparePanel() {
        store.dispatch(mutations.NAMESPACE + 'closeComparePanel');
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
