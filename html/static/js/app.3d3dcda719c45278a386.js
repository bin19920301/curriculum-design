webpackJsonp([22],{NHnr:function(e,n,t){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var r=t("7+uW"),i={render:function(){var e=this.$createElement,n=this._self._c||e;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},staticRenderFns:[]};var u=t("VU/8")(null,i,!1,function(e){t("SR92")},null,null).exports,a=t("YaEn"),o=t("zL8q"),c=t.n(o);t("tvR6");r.default.use(c.a),r.default.use(a.a),r.default.config.productionTip=!1,r.default.prototype.$sortBykey=function(e,n){return e.sort(function(e,t){var r=e[n],i=t[n];return r<i?-1:r>i?1:0})},r.default.prototype.$timeChange=function(e){if(!e)return"";var n=new Date(e),t=n.getFullYear(),r=n.getMonth()+1;r=r<10?"0"+r:r;var i=n.getDate();i=i<10?"0"+i:i;var u=n.getHours();u=u<10?"0"+u:u;var a=n.getMinutes();a=a<10?"0"+a:a;var o=n.getSeconds();return t+"-"+r+"-"+i+" "+u+":"+a+":"+(o=o<10?"0"+o:o)},r.default.prototype.$openBlank=function(e,n){var t=0===(arguments.length>2&&void 0!==arguments[2]?arguments[2]:0)?a.a.resolve({name:e,params:n}):a.a.resolve({name:e,query:n});window.open(t.href,"_blank")},new r.default({el:"#app",router:a.a,components:{App:u},template:"<App/>"})},SR92:function(e,n){},YaEn:function(e,n,t){"use strict";var r=t("Xxa5"),i=t.n(r),u=t("exGp"),a=t.n(u),o=t("7+uW"),c=t("/ocq"),d=(t("mrNh"),t("iPXC")),s=this;o.default.use(c.a);var p,l=new c.a({routes:[{path:"/"},{path:"/newcourse/:pid",name:"newcourse",component:function(){return t.e(13).then(t.bind(null,"D1k3"))},meta:{title:"新建教学"}},{path:"/stuworklist/:pid",name:"stuworklist",component:function(){return Promise.all([t.e(0),t.e(14)]).then(t.bind(null,"Yoc9"))},meta:{title:"课程教学"}},{path:"/workdetail/:id",name:"Sworkdetail",component:function(){return Promise.all([t.e(0),t.e(8)]).then(t.bind(null,"JASZ"))},meta:{title:"学生作业"}},{path:"/newworks/:type",name:"newworks",component:function(){return t.e(9).then(t.bind(null,"PQ+j"))},meta:{title:"新建作业"}},{path:"/stuwork/:id",name:"Tstuwork",component:function(){return Promise.all([t.e(0),t.e(12)]).then(t.bind(null,"sR4F"))},meta:{title:"课程设计"}},{path:"/piyue/:id",name:"piyue",component:function(){return t.e(2).then(t.bind(null,"U1Hr"))},meta:{title:"批阅逻辑"}},{path:"/",component:function(){return Promise.all([t.e(0),t.e(6)]).then(t.bind(null,"MpTN"))},meta:{title:"自述文件"},children:[{path:"/dashboard",component:function(){return t.e(5).then(t.bind(null,"a52u"))},meta:{title:"系统首页"}},{path:"/course",component:function(){return t.e(18).then(t.bind(null,"+zsC"))},meta:{title:"课程设计"}},{path:"/works",component:function(){return t.e(20).then(t.bind(null,"eZ4f"))},meta:{title:"作业列表"}},{path:"/talk",component:function(){return Promise.all([t.e(0),t.e(17)]).then(t.bind(null,"610Y"))},meta:{title:"教师讨论区"}},{path:"/datas",component:function(){return t.e(3).then(t.bind(null,"01kT"))},meta:{title:"基础资料"}},{path:"/message",component:function(){return t.e(15).then(t.bind(null,"ESpO"))},meta:{title:"消息中心"}},{path:"/stumanage",component:function(){return t.e(11).then(t.bind(null,"/h0v"))},meta:{title:"学生管理"}},{path:"/teachermanage",component:function(){return t.e(10).then(t.bind(null,"9lLx"))},meta:{title:"教师管理"}},{path:"/admin",component:function(){return t.e(7).then(t.bind(null,"qwQf"))},meta:{title:"管理员管理"}},{path:"/schoolmanage",component:function(){return t.e(4).then(t.bind(null,"bxHJ"))},meta:{title:"学校组织管理"}},{path:"/stucourse",component:function(){return t.e(16).then(t.bind(null,"pM77"))},meta:{title:"作业详情"}},{path:"/stumessage",component:function(){return t.e(19).then(t.bind(null,"xXVx"))},meta:{title:"消息中心"}}]},{path:"/login",component:function(){return t.e(1).then(t.bind(null,"GF4k"))},meta:{title:"学生登录",requireAuth:!0}},{path:"/teacherlogin",component:function(){return t.e(1).then(t.bind(null,"J7Iy"))},meta:{title:"教师登录",requireAuth:!0}},{path:"/adminlogin",component:function(){return t.e(1).then(t.bind(null,"7qRk"))},meta:{title:"管理员登录",requireAuth:!0}},{path:"*",redirect:"/404"}]});l.beforeEach((p=a()(i.a.mark(function e(n,t,r){var u,a,o,c,p,f,g;return i.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:(u=localStorage.getItem("type"))||(u=0),a=n.meta,a.title,o=a.requireAuth,a.keywordsType,c=["studentToken","teacherToken","adminToken"],p=d.a.getCookie(c[u])?d.a.getCookie(c[u]):"",o?("/"==n.path&&(g=(f=["/stucourse","/course","/stumanage"])[u]),r({path:g})):(console.log("路由需要认证"),p?"/"==n.path?(g=(f=["/stucourse","/course","/stumanage"])[u],r({path:g})):r():(alert("登录已过期,请重新登录"),f=["/login","/teacherlogin","/adminlogin"],l.replace({path:f[u]})));case 7:case"end":return e.stop()}},e,s)})),function(e,n,t){return p.apply(this,arguments)}));n.a=l},eOoE:function(e,n,t){"use strict";t.d(n,"a",function(){return l}),t.d(n,"b",function(){return k}),t.d(n,"c",function(){return w}),t.d(n,"d",function(){return O});var r=t("//Fk"),i=t.n(r),u=t("mtWM"),a=t.n(u),o=t("YaEn"),c=t("mw3O"),d=t.n(c),s=t("iPXC"),p="http://39.105.8.210:8080",l="http://39.105.8.210",f=a.a.create(),g=["studentToken","teacherToken","adminToken"],m=[],b=a.a.CancelToken,h=function(e){return e.url+"_"+e.method},j=function(e){var n=m.map(function(e){return e.token}).indexOf(h(e));n>-1&&(m[n].cancel(),m.splice(n,1))};f.interceptors.request.use(function(e,n){j(e),e.cancelToken=new b(function(n){m.push({token:h(e),cancel:n})});var t=localStorage.getItem("type");return 0==t?e.headers.studentToken=s.a.getCookie(g[t]):1==t?e.headers.teacherToken=s.a.getCookie(g[t]):2==t&&(e.headers.adminToken=s.a.getCookie(g[t])),e},function(e){return i.a.reject(e)}),f.interceptors.response.use(function(e){e.config.url;if(j(e.config),200101!=e.data.status.code)return e.data;var n=localStorage.getItem("type");n||(n=0),alert("身份认证过期,请重新登陆");o.a.replace({path:["/login","/teacherlogin","/adminlogin"][n]})},function(e){if(!e.response)return i.a.reject({msg:"网络连接超时",error:e,code:400});switch(e.response.status){case 401:alert("您没有登录"),o.a.replace({path:"/login"});break;case 403:alert("您没有该操作权限");break;case 500:alert("服务器错误")}return i.a.reject(e.response.data)});var k=function(e,n){var t=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{headers:{"Content-Type":"application/x-www-form-urlencoded"}};return f.post(p+e,d.a.stringify(n),t)},w=function(e,n){var t=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{headers:{"Content-Type":"application/json"}};return f.post(p+e,n,t)},O=function(e,n){var t=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{headers:{"Content-Type":"multipart/form-data"}};return f.post(p+"/design/api"+e,n,t)}},iPXC:function(e,n,t){"use strict";var r={setCookie:function(e,n,t){var r=new Date;r.setTime(r.getTime()+t),r.setDate(r.getDate()+t),document.cookie=e+"="+escape(n)+(null==t?"":";expires="+r.toGMTString())+";path=/"},getCookie:function(e){var n=new RegExp("(^| )"+e+"=([^;]*)(;|$)");return document.cookie.match(n)?document.cookie.match(n)[2]:null},delCookie:function(e){var n=new Date;n.setTime(n.getTime()-1),null!=r.getCookie(e)&&(document.cookie=e+"=; expires=Thu, 01 Jan 1970 00:00:01 GMT;")}};n.a=r},mrNh:function(e,n,t){"use strict";t.d(n,"_16",function(){return i}),t.d(n,"_20",function(){return u}),t.d(n,"p",function(){return a}),t.d(n,"X",function(){return o}),t.d(n,"n",function(){return c}),t.d(n,"W",function(){return d}),t.d(n,"_26",function(){return s}),t.d(n,"_7",function(){return p}),t.d(n,"P",function(){return l}),t.d(n,"Y",function(){return f}),t.d(n,"h",function(){return g}),t.d(n,"_12",function(){return m}),t.d(n,"_13",function(){return b}),t.d(n,"C",function(){return h}),t.d(n,"V",function(){return j}),t.d(n,"g",function(){return k}),t.d(n,"A",function(){return w}),t.d(n,"_17",function(){return O}),t.d(n,"Z",function(){return y}),t.d(n,"S",function(){return I}),t.d(n,"q",function(){return _}),t.d(n,"T",function(){return v}),t.d(n,"_1",function(){return T}),t.d(n,"O",function(){return S}),t.d(n,"o",function(){return N}),t.d(n,"_0",function(){return P}),t.d(n,"D",function(){return z}),t.d(n,"_27",function(){return C}),t.d(n,"_4",function(){return x}),t.d(n,"f",function(){return q}),t.d(n,"x",function(){return D}),t.d(n,"J",function(){return R}),t.d(n,"s",function(){return E}),t.d(n,"_6",function(){return F}),t.d(n,"j",function(){return M}),t.d(n,"z",function(){return Y}),t.d(n,"_24",function(){return A}),t.d(n,"K",function(){return L}),t.d(n,"a",function(){return H}),t.d(n,"_9",function(){return J}),t.d(n,"t",function(){return X}),t.d(n,"_3",function(){return G}),t.d(n,"_22",function(){return W}),t.d(n,"w",function(){return $}),t.d(n,"e",function(){return B}),t.d(n,"_2",function(){return Q}),t.d(n,"d",function(){return U}),t.d(n,"v",function(){return V}),t.d(n,"_10",function(){return Z}),t.d(n,"N",function(){return K}),t.d(n,"Q",function(){return ee}),t.d(n,"l",function(){return ne}),t.d(n,"_8",function(){return te}),t.d(n,"_25",function(){return re}),t.d(n,"B",function(){return ie}),t.d(n,"M",function(){return ue}),t.d(n,"b",function(){return ae}),t.d(n,"_11",function(){return oe}),t.d(n,"u",function(){return ce}),t.d(n,"L",function(){return de}),t.d(n,"_21",function(){return se}),t.d(n,"_28",function(){return pe}),t.d(n,"_33",function(){return le}),t.d(n,"_15",function(){return fe}),t.d(n,"_19",function(){return ge}),t.d(n,"E",function(){return me}),t.d(n,"_14",function(){return be}),t.d(n,"k",function(){return he}),t.d(n,"_31",function(){return je}),t.d(n,"_18",function(){return ke}),t.d(n,"m",function(){return we}),t.d(n,"_32",function(){return Oe}),t.d(n,"_30",function(){return ye}),t.d(n,"_29",function(){return Ie}),t.d(n,"_34",function(){return _e}),t.d(n,"r",function(){return ve}),t.d(n,"_5",function(){return Te}),t.d(n,"i",function(){return Se}),t.d(n,"_23",function(){return Ne}),t.d(n,"y",function(){return Pe}),t.d(n,"F",function(){return ze}),t.d(n,"G",function(){return Ce}),t.d(n,"I",function(){return xe}),t.d(n,"H",function(){return qe}),t.d(n,"c",function(){return De}),t.d(n,"R",function(){return Re}),t.d(n,"U",function(){return Ee});var r=t("eOoE"),i=function(e,n){return Object(r.b)("/design/api/student/login/",{name:e,number:n})},u=function(e,n){return Object(r.b)("/design/api/teacher/login/",{number:e,password:n})},a=function(e,n){return Object(r.b)("/design/api/admin/login/",{number:e,password:n})},o=function(e,n,t){return Object(r.b)("/design/api/teaching/getteachingbycreatoridandstatus/",{status:e,pageNum:n,pageSize:t})},c=function(e,n,t,i){return Object(r.c)("/design/api/teaching/addteaching/",{name:e,teacherReminder:n,deadlineTime:t,works:i})},d=function(e){return Object(r.b)("/design/api/teaching/getteachingbyId/",{id:e})},s=function(e,n,t,i,u){return Object(r.c)("/design/api/teaching/updateteaching/",{id:e,name:n,teacherReminder:t,deadlineTime:i,works:u})},p=function(e,n,t){return Object(r.b)("/design/api/student/liststudentbyparam/",{enrollmentId:e,academyId:n,classId:t})},l=function(){return Object(r.b)("/design/api/workproject/getallworkprojectlist/",{})},f=function(e){return Object(r.b)("/design/api/work/getteacherworkinfobyid/",{id:e})},g=function(e,n){return Object(r.b)("/design/api/workmessage/addmessagebyteacher/",{workId:e,content:n})},m=function(e){return Object(r.b)("/design/api/work/return/",{id:e})},b=function(e,n){return Object(r.b)("/design/api/work/score/",{id:e,score:n})},h=function(e){return Object(r.b)("/design/api/workmessage/deleteteahcermessage/",{id:e})},j=function(e,n,t){return Object(r.b)("/design/api/workmessage/getteachermessage/",{read:e,pageNum:n,pageSize:t})},k=function(e,n){return Object(r.b)("/design/api/workmessage/addmessagebystudent/",{workId:e,content:n})},w=function(e){return Object(r.b)("/design/api/workmessage/deletestudentmessage/",{id:e})},O=function(e){return Object(r.b)("/design/api/work/submit/",{id:e})},y=function(e,n,t){return Object(r.b)("/design/api/work/getworklistbystudentid/",{isDone:e,pageNum:n,pageSize:t})},I=function(e,n,t){return Object(r.b)("/design/api/workmessage/getstudentmessage/",{read:e,pageNum:n,pageSize:t})},_=function(){return Object(r.b)("/design/api/workmessage/countstudentunreadmessage/",{})},v=function(e){return Object(r.b)("/design/api/work/getstudentworkinfobyid/",{id:e})},T=function(e,n){return Object(r.b)("/design/api/workproject/getworkprojectlist/",{pageNum:e,pageSize:n})},S=function(){return Object(r.b)("/design/api/folder/getallfolder/",{})},N=function(e,n,t,i){return Object(r.b)("/design/api/workproject/addworkproject/",{name:e,desc:n,fileIdList:t,referenceSolutionList:i})},P=function(e){return Object(r.b)("/design/api/workproject/getworkprojectinfo/",{workProjectId:e})},z=function(e){return Object(r.b)("/design/api/workproject/deleteworkproject/",{workProjectId:e})},C=function(e,n,t,i,u){return Object(r.b)("/design/api/workproject/updateworkproject/",{id:e,name:n,desc:t,fileIdList:i,referenceSolutionList:u})},x=function(e,n){return Object(r.b)("/design/api/folder/listfolder/",{pageNum:e,pageSize:n})},q=function(e){return Object(r.b)("/design/api/folder/addfolder/",{name:e})},D=function(e){return Object(r.b)("/design/api/folder/deletefolder/",{id:e})},R=function(e,n,t){return Object(r.b)("/design/api/file/getFileByFolderId/",{pageNum:e,pageSize:n,folderId:t})},E=function(e){return Object(r.b)("/design/api/file/deleteFile/",{id:e})},F=function(e,n){return Object(r.b)("/design/api/student/liststudent/",{pageNum:e,pageSize:n})},M=function(e,n,t,i,u){return Object(r.b)("/design/api/student/addstudent/",{number:e,name:n,academyId:t,enrollmentId:i,classId:u})},Y=function(e){return Object(r.b)("/design/api/student/deletestudent/",{id:e})},A=function(e,n,t,i,u,a){return Object(r.b)("/design/api/student/updatestudent/",{id:e,number:n,name:t,academyId:i,enrollmentId:u,classId:a})},L=function(e,n){return Object(r.b)("/design/api/academy/getacademylist/",{pageNum:e,pageSize:n})},H=function(e){return Object(r.b)("/design/api/academy/addacademy/",{name:e})},J=function(e,n){return Object(r.b)("/design/api/academy/renameacademy/",{id:e,name:n})},X=function(e){return Object(r.b)("/design/api/academy/deleteacademy/",{id:e})},G=function(e,n){return Object(r.b)("/design/api/enrollmentyear/listenrollmentyear/",{pageNum:e,pageSize:n})},W=function(e,n){return Object(r.b)("/design/api/enrollmentyear/updateenrollmentyear/",{id:e,enrollmentYear:n})},$=function(e){return Object(r.b)("/design/api/enrollmentyear/deleteenrollmentyear/",{id:e})},B=function(e){return Object(r.b)("/design/api/enrollmentyear/addenrollmentyear/",{enrollmentYear:e})},Q=function(){return Object(r.b)("/design/api/enrollmentyear/listallenrollmentyear/",{})},U=function(e,n){return Object(r.b)("/design/api/class/addclass/",{academyId:e,name:n})},V=function(e){return Object(r.b)("/design/api/class/deleteclass/",{id:e})},Z=function(e,n){return Object(r.b)("/design/api/class/renameclass/",{name:e,classId:n})},K=function(){return Object(r.b)("/design/api/academy/getallacademylist/",{})},ee=function(e){return Object(r.b)("/design/api/class/getclassbyacademyid/",{academyId:e})},ne=function(e,n,t){return Object(r.b)("/design/api/teacher/addteacher/",{number:e,name:n,academyId:t})},te=function(e,n){return Object(r.b)("/design/api/teacher/listteacher/",{pageNum:e,pageSize:n})},re=function(e,n,t,i,u){return Object(r.b)("/design/api/teacher/updateteacher/",{id:e,academyId:n,number:t,name:i,password:u})},ie=function(e){return Object(r.b)("/design/api/teacher/deleteteacher/",{id:e})},ue=function(e,n){return Object(r.b)("/design/api/admin/getadminlist/",{pageNum:e,pageSize:n})},ae=function(e,n,t){return Object(r.b)("/design/api/admin/addadmin/",{number:e,name:n,password:t})},oe=function(e){return Object(r.b)("/design/api/admin/resetadminpassword/",{id:e})},ce=function(e){return Object(r.b)("/design/api/admin/deleteadmin/",{id:e})},de=function(e){return Object(r.b)("/design/api/admin/getadminbyid/",{id:e})},se=function(e,n,t){return Object(r.b)("/design/api/admin/updateadmin/",{id:e,number:n,name:t})},pe=function(e,n){return Object(r.b)("/design/api/admin/updatepassword/",{oldPassword:e,newPassword:n})},le=function(e,n){return Object(r.b)("/design/api/teacher/updatepassword/",{oldPassword:e,newPassword:n})},fe=function(e,n,t,i){return Object(r.b)("/design/api/workmessage/studentlistmessage/",{workId:e,pageNum:n,pageSize:t,startId:i})},ge=function(e,n,t,i){return Object(r.b)("/design/api/workmessage/teacherlistmessage/",{workId:e,pageNum:n,pageSize:t,startId:i})},me=function(e){return Object(r.b)("/design/api/workfile/deletewrokfile/",{id:e})},be=function(e,n,t,i){return Object(r.b)("/design/api/teachingmessage/studentlistbyteachindid/",{teachingId:e,pageNum:n,pageSize:t,startId:i})},he=function(e,n){return Object(r.b)("/design/api/teachingmessage/addstudentmessage/",{teachingId:e,content:n})},je=function(e){return Object(r.b)("/design/api/teachingmessage/deletestudentmessage/",{id:e})},ke=function(e,n,t,i){return Object(r.b)("/design/api/teachingmessage/teacherlistbyteachindid/",{teachingId:e,pageNum:n,pageSize:t,startId:i})},we=function(e,n){return Object(r.b)("/design/api/teachingmessage/addteachermessage/",{teachingId:e,content:n})},Oe=function(e){return Object(r.b)("/design/api/teachingmessage/deleteteachermessage/",{id:e})},ye=function(e,n,t){return Object(r.b)("/design/api/teachermessage/listmessage/",{pageNum:e,pageSize:n,startId:t})},Ie=function(e){return Object(r.b)("/design/api/teachermessage/addmessage/",{content:e})},_e=function(e){return Object(r.b)("/design/api/teachermessage/deletemessage/",{id:e})},ve=function(){return Object(r.b)("/design/api/workmessage/countteacherunreadmessage/",{})},Te=function(e,n,t){return Object(r.b)("/design/api/procedurerules/listrules/",{projectId:e,pageNum:n,pageSize:t})},Se=function(e,n,t){return Object(r.b)("/design/api/procedurerules/addrule/",{workProjectId:e,rulesType:n,rulesDetails:t})},Ne=function(e,n,t,i){return Object(r.b)("/design/api/procedurerules/updaterule/",{id:e,workProjectId:n,rulesType:t,rulesDetails:i})},Pe=function(e){return Object(r.b)("/design/api/procedurerules/deleterule/",{id:e})},ze=function(e){return Object(r.b)("/design/api/finishedsurface/list/",{workProjectId:e})},Ce=function(e,n,t,i){return Object(r.b)("/design/api/finishedsurface/add/",{workProjectId:e,surfaceId:n,type:t,name:i})},xe=function(e,n,t,i){return Object(r.b)("/design/api/finishedsurface/update/",{workProjectId:e,surfaceId:n,type:t,name:i})},qe=function(e,n){return Object(r.b)("/design/api/finishedsurface/del/",{workProjectId:e,surfaceId:n})},De=function(e,n,t,i,u,a,o,c){return Object(r.c)("/design/api/work/addcard/",{workId:e,partNumber:n,partName:t,productType:i,materials:u,workblankWeight:a,workblankKind:o,processList:c})},Re=function(e){return Object(r.b)("/design/api/card/getstudentcardbyworkid/",{id:e})},Ee=function(e){return Object(r.b)("/design/api/card/getteachercardbyworkid/",{id:e})}},tvR6:function(e,n){}},["NHnr"]);
//# sourceMappingURL=app.3d3dcda719c45278a386.js.map