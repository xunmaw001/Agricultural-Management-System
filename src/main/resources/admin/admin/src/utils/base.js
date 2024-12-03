const base = {
    get() {
        return {
            url : "http://localhost:8080/nongshiguanli/",
            name: "nongshiguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/nongshiguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "农事管理系统"
        } 
    }
}
export default base
