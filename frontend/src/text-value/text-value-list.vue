<template>
    <div v-loading.body="loading">
        <div>
            <h2>Text values</h2>
            <el-card>
                <el-table :data="textValues" style="width: 100%" stripe>
                    <el-table-column prop="id" label="Id"></el-table-column>
                    <el-table-column prop="textValue" label="Value"></el-table-column>
                    <el-table-column prop="audWhenCreate" label="Created"></el-table-column>
                    <el-table-column prop="audWhen" label="Updated"></el-table-column>
                </el-table>
            </el-card>

        </div>
    </div>
</template>

<script>
  import Vue from 'vue'
  import Vuex, {mapState} from 'vuex'
  import ElementUI from 'element-ui'
  import 'element-ui/lib/theme-chalk/index.css'
  import store from '../index-store';
  import router from '../index-router';

  import locale from 'element-ui/lib/locale'
  import lang from 'element-ui/lib/locale/lang/ru-RU'

  import * as mutations from './text-value-mutations'


  locale.use(lang)
  Vue.use(ElementUI)

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
    methods: {}
  })
</script>
