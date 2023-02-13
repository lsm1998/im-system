import createAxios from '/@/utils/axios'
import {useAdminInfo} from '/@/stores/adminInfo'

const controllerUrl = '/base/api/'

export function index() {
    return createAxios({
        url: '/base/api/index',
        method: 'get',
    })
}

export function loginInfo(): ApiPromise {
    return createAxios({
        url: controllerUrl + 'loginInfo',
        method: 'get',
    }) as ApiPromise
}

export function login(params: object = {}): ApiPromise {
    return createAxios({
        url: controllerUrl + 'loginInfo',
        data: params,
        method: 'post',
    }) as ApiPromise
}

export function logout() {
    const adminInfo = useAdminInfo()
    return createAxios({
        url: controllerUrl + 'logout',
        method: 'POST',
        data: {
            refresh_token: adminInfo.getToken('refresh'),
        },
    })
}
