import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { loadLang } from '/@/lang'
import { registerIcons } from '/@/utils/common'
import ElementPlus from 'element-plus'
import mitt from 'mitt'
import pinia from '/@/stores'
import { directives } from '/@/utils/directives'
import 'element-plus/dist/index.css'
import 'element-plus/theme-chalk/display.css'
import '/@/styles/index.scss'
// modules import mark, Please do not remove.

async function start() {
    const app = createApp(App)
    app.use(pinia)

    // 全局语言包加载
    const i18n = await loadLang(app)

    app.use(router)
    // @ts-ignore
    app.use(ElementPlus, { i18n: i18n.global.t })

    // 全局注册
    directives(app) // 指令
    registerIcons(app) // icons

    app.mount('#app')

    // modules start mark, Please do not remove.

    app.config.globalProperties.eventBus = mitt()
}

start()
