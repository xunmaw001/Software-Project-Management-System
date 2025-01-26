const base = {
    get() {
        return {
            url : "http://localhost:8080/ruanjianxiangmu/",
            name: "ruanjianxiangmu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ruanjianxiangmu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "软件项目管理系统"
        } 
    }
}
export default base
