webpackJsonp([19],{NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r=n("7+uW"),a={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var o=n("VU/8")(null,a,!1,function(e){n("SR92")},null,null).exports,u=n("YaEn"),i=n("zL8q"),c=n.n(i);n("tvR6");r.default.use(c.a),r.default.config.productionTip=!1,r.default.prototype.$timeChange=function(e){if(!e)return"";var t=new Date(e);return t.getFullYear()+"-"+((t.getMonth()+1<10?"0"+(t.getMonth()+1):t.getMonth()+1)+"-")+(t.getDate()+" ")+(t.getHours()+":")+(t.getMinutes()+":")+t.getSeconds()},r.default.prototype.$openBlank=function(e,t){var n=0===(arguments.length>2&&void 0!==arguments[2]?arguments[2]:0)?u.a.resolve({name:e,params:t}):u.a.resolve({name:e,query:t});window.open(n.href,"_blank")},new r.default({el:"#app",router:u.a,components:{App:o},template:"<App/>"})},SR92:function(e,t){},YaEn:function(e,t,n){"use strict";var r=n("Xxa5"),a=n.n(r),o=n("exGp"),u=n.n(o),i=n("7+uW"),c=n("/ocq"),l=n("mrNh"),d=n("iPXC"),s=this;i.default.use(c.a);var p,m=new c.a({routes:[{path:"/",redirect:"/dashboard"},{path:"/newcourse/:pid",name:"newcourse",component:function(){return n.e(4).then(n.bind(null,"D1k3"))},meta:{title:"新建教学"}},{path:"/stuworklist",name:"stuworklist",component:function(){return n.e(8).then(n.bind(null,"Yoc9"))},meta:{title:"课程教学"}},{path:"/workdetail",name:"workdetail",component:function(){return n.e(11).then(n.bind(null,"JASZ"))},meta:{title:"学生作业"}},{path:"/newworks",name:"newworks",component:function(){return n.e(10).then(n.bind(null,"PQ+j"))},meta:{title:"新建作业"}},{path:"/stuwork",name:"Tstuwork",component:function(){return n.e(6).then(n.bind(null,"sR4F"))},meta:{title:"课程设计"}},{path:"/",component:function(){return n.e(1).then(n.bind(null,"MpTN"))},meta:{title:"自述文件"},children:[{path:"/dashboard",component:function(){return n.e(3).then(n.bind(null,"a52u"))},meta:{title:"系统首页"}},{path:"/course",component:function(){return n.e(17).then(n.bind(null,"+zsC"))},meta:{title:"课程设计"}},{path:"/works",component:function(){return n.e(14).then(n.bind(null,"eZ4f"))},meta:{title:"作业列表"}},{path:"/datas",component:function(){return n.e(5).then(n.bind(null,"01kT"))},meta:{title:"基础资料"}},{path:"/message",component:function(){return n.e(16).then(n.bind(null,"ESpO"))},meta:{title:"消息中心"}},{path:"/stumanage",component:function(){return n.e(7).then(n.bind(null,"/h0v"))},meta:{title:"学生管理"}},{path:"/teachermanage",component:function(){return n.e(12).then(n.bind(null,"9lLx"))},meta:{title:"教师管理"}},{path:"/admin",component:function(){return n.e(9).then(n.bind(null,"qwQf"))},meta:{title:"管理员管理"}},{path:"/schoolmanage",component:function(){return n.e(2).then(n.bind(null,"bxHJ"))},meta:{title:"学校组织管理"}},{path:"/stucourse",component:function(){return n.e(13).then(n.bind(null,"pM77"))},meta:{title:"作业详情"}},{path:"/stumessage",component:function(){return n.e(15).then(n.bind(null,"xXVx"))},meta:{title:"消息中心"}}]},{path:"/login",component:function(){return n.e(0).then(n.bind(null,"GF4k"))},meta:{title:"学生登录"}},{path:"/login1",component:function(){return n.e(0).then(n.bind(null,"J7Iy"))},meta:{title:"教师登录"}},{path:"/login2",component:function(){return n.e(0).then(n.bind(null,"7qRk"))},meta:{title:"管理员登录"}},{path:"*",redirect:"/404"}]}),f=function(e,t,n){document.title=e||"查专利查商标,就上知险查"};m.beforeEach((p=u()(a.a.mark(function e(t,n,r){var o,u,i,c,p;return a.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:if(o=t.meta,u=o.title,i=o.requireAuth,o.keywordsType,c=d.a.getCookie("access_token")?d.a.getCookie("access_token"):"",!i){e.next=24;break}if(console.log("路由需要认证"),!c){e.next=20;break}return e.prev=5,e.next=8,Object(l.fetchCheck_token)(c);case 8:p=e.sent,console.log(p),p.user_name?(console.log("路由认证成功"),f(u),r()):(console.log("路由认证失败，身份认证过期,请重新登陆"),alert("身份认证过期,请重新登陆"),m.replace({path:"/login"})),e.next=18;break;case 13:e.prev=13,e.t0=e.catch(5),console.log("网络故障"),console.log(e.t0),m.replace({path:"/login"});case 18:e.next=22;break;case 20:alert("您没有登录"),m.replace({path:"/login"});case 22:e.next=27;break;case 24:console.log("路由不需要认证"),f(u),r();case 27:case"end":return e.stop()}},e,s,[[5,13]])})),function(e,t,n){return p.apply(this,arguments)}));t.a=m},iPXC:function(e,t,n){"use strict";var r={setCookie:function(e,t,n){var r=new Date;r.setTime(r.getTime()+n),r.setDate(r.getDate()+n),document.cookie=e+"="+escape(t)+(null==n?"":";expires="+r.toGMTString())+";path=/"},getCookie:function(e){var t=new RegExp("(^| )"+e+"=([^;]*)(;|$)");return document.cookie.match(t)?document.cookie.match(t)[2]:null},delCookie:function(e){var t=new Date;t.setTime(t.getTime()-1),null!=r.getCookie(e)&&(document.cookie=e+"=; expires=Thu, 01 Jan 1970 00:00:01 GMT;")}};t.a=r},mrNh:function(e,t,n){"use strict";var r=n("//Fk"),a=n.n(r),o=n("mtWM"),u=n.n(o),i=n("YaEn"),c=n("mw3O"),l=n.n(c),d=n("iPXC"),s=u.a.create(),p=(d.a.getCookie("userToken")&&d.a.getCookie("userToken"),[]),m=u.a.CancelToken,f=function(e){return e.url+"_"+e.method},h=function(e){var t=p.map(function(e){return e.token}).indexOf(f(e));t>-1&&(p[t].cancel(),p.splice(t,1))};s.interceptors.request.use(function(e,t){return h(e),e.cancelToken=new m(function(t){p.push({token:f(e),cancel:t})}),e.headers.Authorization="Basic Y3Jtc3lzdGVtOnpnZ2NybQ==",e},function(e){return a.a.reject(e)}),s.interceptors.response.use(function(e){e.config.url;return h(e.config),303===e.data.code&&(console.log("请求认证失败，身份认证过期,请重新登陆"),alert("身份认证过期,请重新登陆"),i.a.replace({path:"/login"})),e.data},function(e){if(!e.response)return a.a.reject({msg:"网络连接超时",error:e,code:400});switch(e.response.status){case 401:alert("您没有登录"),i.a.replace({path:"/login"});break;case 403:alert("您没有该操作权限");break;case 500:alert("服务器错误")}return a.a.reject(e.response.data)});var g=function(e,t){var n=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{headers:{"Content-Type":"application/x-www-form-urlencoded"}};return s.post(e,l.a.stringify(t),n)};n.d(t,"u",function(){return k}),n.d(t,"e",function(){return b}),n.d(t,"l",function(){return y}),n.d(t,"C",function(){return w}),n.d(t,"n",function(){return v}),n.d(t,"a",function(){return x}),n.d(t,"w",function(){return C}),n.d(t,"h",function(){return T}),n.d(t,"t",function(){return I}),n.d(t,"B",function(){return N}),n.d(t,"k",function(){return S}),n.d(t,"d",function(){return z}),n.d(t,"s",function(){return M}),n.d(t,"c",function(){return _}),n.d(t,"j",function(){return q}),n.d(t,"x",function(){return D}),n.d(t,"q",function(){return R}),n.d(t,"r",function(){return Y}),n.d(t,"f",function(){return j}),n.d(t,"v",function(){return E}),n.d(t,"D",function(){return A}),n.d(t,"m",function(){return J}),n.d(t,"p",function(){return O}),n.d(t,"b",function(){return F}),n.d(t,"y",function(){return G}),n.d(t,"i",function(){return P}),n.d(t,"o",function(){return X}),n.d(t,"A",function(){return H}),n.d(t,"z",function(){return $});var k=function(e,t){return g("http://39.105.8.210:8080/student/liststudent/",{pageNum:e,pageSize:t})},b=function(e,t,n,r,a){return g("http://39.105.8.210:8080/student/addstudent/",{number:e,name:t,academyId:n,enrollmentId:r,classId:a})},y=function(e){return g("http://39.105.8.210:8080/student/deletestudent/",{id:e})},w=function(e,t,n,r,a,o){return g("http://39.105.8.210:8080/student/updatestudent/",{id:e,number:t,name:n,academyId:r,enrollmentId:a,classId:o})},v=function(e,t){return g("http://39.105.8.210:8080/academy/getacademylist/",{pageNum:e,pageSize:t})},x=function(e){return g("http://39.105.8.210:8080/academy/addacademy/",{name:e})},C=function(e,t){return g("http://39.105.8.210:8080/academy/renameacademy/",{id:e,name:t})},T=function(e){return g("http://39.105.8.210:8080/academy/deleteacademy/",{id:e})},I=function(e,t){return g("http://39.105.8.210:8080/enrollmentyear/listenrollmentyear/",{pageNum:e,pageSize:t})},N=function(e,t){return g("http://39.105.8.210:8080/enrollmentyear/updateenrollmentyear/",{id:e,enrollmentYear:t})},S=function(e){return g("http://39.105.8.210:8080/enrollmentyear/deleteenrollmentyear/",{id:e})},z=function(e){return g("http://39.105.8.210:8080/enrollmentyear/addenrollmentyear/",{enrollmentYear:e})},M=function(){return g("http://39.105.8.210:8080/enrollmentyear/listallenrollmentyear/",{})},_=function(e,t){return g("http://39.105.8.210:8080/class/addclass/",{academyId:e,name:t})},q=function(e){return g("http://39.105.8.210:8080/class/deleteclass/",{id:e})},D=function(e,t){return g("http://39.105.8.210:8080/class/renameclass/",{name:e,classId:t})},R=function(){return g("http://39.105.8.210:8080/academy/getallacademylist/",{})},Y=function(e){return g("http://39.105.8.210:8080/class/getclassbyacademyid/",{academyId:e})},j=function(e,t,n){return g("http://39.105.8.210:8080/teacher/addteacher/",{number:e,name:t,academyId:n})},E=function(e,t){return g("http://39.105.8.210:8080/teacher/listteacher/",{pageNum:e,pageSize:t})},A=function(e,t,n,r,a){return g("http://39.105.8.210:8080/teacher/updateteacher/",{id:e,academyId:t,number:n,name:r,password:a})},J=function(e){return g("http://39.105.8.210:8080/teacher/deleteteacher/",{id:e})},O=function(e,t){return g("http://39.105.8.210:8080/admin/getadminlist/",{pageNum:e,pageSize:t})},F=function(e,t,n){return g("http://39.105.8.210:8080/admin/addadmin/",{number:e,name:t,password:n})},G=function(e){return g("http://39.105.8.210:8080/admin/resetadminpassword/",{id:e})},P=function(e){return g("http://39.105.8.210:8080/admin/deleteadmin/",{id:e})},X=function(e){return g("http://39.105.8.210:8080/admin/getadminbyid/",{id:e})},H=function(e,t,n,r){return g("http://39.105.8.210:8080/admin/updateadmin/",{id:e,number:t,name:n,password:r})},$=function(e){return g("http://39.105.8.210:8080/test/",{id:e})}},tvR6:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.39203541b1b71171b90e.js.map