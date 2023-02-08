import axios, {AxiosResponse, InternalAxiosRequestConfig} from "axios";

axios.interceptors.request.use(function (config: InternalAxiosRequestConfig) {
    config.headers["token"] = "token"
    return config
}, function (err :any) {
    
})

axios.interceptors.response.use(function (value :AxiosResponse) {
    return value.data
})
