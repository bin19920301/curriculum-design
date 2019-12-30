webpackJsonp([20],{NHnr:function(e,n,t){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var r=t("7+uW"),u={render:function(){var e=this.$createElement,n=this._self._c||e;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},staticRenderFns:[]};var o=t("VU/8")(null,u,!1,function(e){t("SR92")},null,null).exports,a=t("YaEn"),i=t("zL8q"),c=t.n(i);t("tvR6");r.default.use(c.a),r.default.use(a.a),r.default.config.productionTip=!1,r.default.prototype.$sortBykey=function(e,n){return e.sort(function(e,t){var r=e[n],u=t[n];return r<u?-1:r>u?1:0})},r.default.prototype.$timeChange=function(e){if(!e)return"";var n=new Date(e),t=n.getFullYear(),r=n.getMonth()+1;r=r<10?"0"+r:r;var u=n.getDate();u=u<10?"0"+u:u;var o=n.getHours();o=o<10?"0"+o:o;var a=n.getMinutes();a=a<10?"0"+a:a;var i=n.getSeconds();return t+"-"+r+"-"+u+" "+o+":"+a+":"+(i=i<10?"0"+i:i)},r.default.prototype.$openBlank=function(e,n){var t=0===(arguments.length>2&&void 0!==arguments[2]?arguments[2]:0)?a.a.resolve({name:e,params:n}):a.a.resolve({name:e,query:n});window.open(t.href,"_blank")},new r.default({el:"#app",router:a.a,components:{App:o},template:"<App/>"})},SR92:function(e,n){},YaEn:function(e,n,t){"use strict";var r=t("Xxa5"),u=t.n(r),o=t("exGp"),a=t.n(o),i=t("7+uW"),c=t("/ocq"),d=(t("mrNh"),t("iPXC")),l=this;i.default.use(c.a);var s,f=new c.a({routes:[{path:"/"},{path:"/newcourse/:pid",name:"newcourse",component:function(){return t.e(12).then(t.bind(null,"D1k3"))},meta:{title:"新建教学"}},{path:"/stuworklist/:pid",name:"stuworklist",component:function(){return t.e(9).then(t.bind(null,"Yoc9"))},meta:{title:"课程教学"}},{path:"/workdetail/:id",name:"Sworkdetail",component:function(){return Promise.all([t.e(1),t.e(10)]).then(t.bind(null,"JASZ"))},meta:{title:"学生作业"}},{path:"/newworks/:type",name:"newworks",component:function(){return t.e(6).then(t.bind(null,"PQ+j"))},meta:{title:"新建作业"}},{path:"/stuwork/:id",name:"Tstuwork",component:function(){return Promise.all([t.e(1),t.e(7)]).then(t.bind(null,"sR4F"))},meta:{title:"课程设计"}},{path:"/",component:function(){return Promise.all([t.e(1),t.e(4)]).then(t.bind(null,"MpTN"))},meta:{title:"自述文件"},children:[{path:"/dashboard",component:function(){return t.e(5).then(t.bind(null,"a52u"))},meta:{title:"系统首页"}},{path:"/course",component:function(){return t.e(17).then(t.bind(null,"+zsC"))},meta:{title:"课程设计"}},{path:"/works",component:function(){return t.e(16).then(t.bind(null,"eZ4f"))},meta:{title:"作业列表"}},{path:"/datas",component:function(){return t.e(3).then(t.bind(null,"01kT"))},meta:{title:"基础资料"}},{path:"/message",component:function(){return t.e(14).then(t.bind(null,"ESpO"))},meta:{title:"消息中心"}},{path:"/stumanage",component:function(){return t.e(11).then(t.bind(null,"/h0v"))},meta:{title:"学生管理"}},{path:"/teachermanage",component:function(){return t.e(8).then(t.bind(null,"9lLx"))},meta:{title:"教师管理"}},{path:"/admin",component:function(){return t.e(13).then(t.bind(null,"qwQf"))},meta:{title:"管理员管理"}},{path:"/schoolmanage",component:function(){return t.e(2).then(t.bind(null,"bxHJ"))},meta:{title:"学校组织管理"}},{path:"/stucourse",component:function(){return t.e(15).then(t.bind(null,"pM77"))},meta:{title:"作业详情"}},{path:"/stumessage",component:function(){return t.e(18).then(t.bind(null,"xXVx"))},meta:{title:"消息中心"}}]},{path:"/login",component:function(){return t.e(0).then(t.bind(null,"GF4k"))},meta:{title:"学生登录",requireAuth:!0}},{path:"/login1",component:function(){return t.e(0).then(t.bind(null,"J7Iy"))},meta:{title:"教师登录",requireAuth:!0}},{path:"/login2",component:function(){return t.e(0).then(t.bind(null,"7qRk"))},meta:{title:"管理员登录",requireAuth:!0}},{path:"*",redirect:"/404"}]}),m=function(e,n,t){document.title=e||"查专利查商标,就上知险查"};f.beforeEach((s=a()(u.a.mark(function e(n,t,r){var o,a,i,c,s,p,g,h;return u.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:(o=localStorage.getItem("type"))||(o=0),a=n.meta,i=a.title,c=a.requireAuth,a.keywordsType,s=["studentToken","teacherToken","adminToken"],p=d.a.getCookie(s[o])?d.a.getCookie(s[o]):"",c?("/"==n.path&&(h=(g=["/stucourse","/course","/stumanage"])[o]),m(i),r({path:h})):(console.log("路由需要认证"),p?"/"==n.path?(h=(g=["/stucourse","/course","/stumanage"])[o],m(i),r({path:h})):(m(i),r()):(alert("登录已过期,请重新登录"),g=["/login","/login1","/login2"],f.replace({path:g[o]})));case 7:case"end":return e.stop()}},e,l)})),function(e,n,t){return s.apply(this,arguments)}));n.a=f},iPXC:function(e,n,t){"use strict";var r={setCookie:function(e,n,t){var r=new Date;r.setTime(r.getTime()+t),r.setDate(r.getDate()+t),document.cookie=e+"="+escape(n)+(null==t?"":";expires="+r.toGMTString())+";path=/"},getCookie:function(e){var n=new RegExp("(^| )"+e+"=([^;]*)(;|$)");return document.cookie.match(n)?document.cookie.match(n)[2]:null},delCookie:function(e){var n=new Date;n.setTime(n.getTime()-1),null!=r.getCookie(e)&&(document.cookie=e+"=; expires=Thu, 01 Jan 1970 00:00:01 GMT;")}};n.a=r},mrNh:function(e,n,t){"use strict";var r=t("//Fk"),u=t.n(r),o=t("mtWM"),a=t.n(o),i=t("YaEn"),c=t("mw3O"),d=t.n(c),l=t("iPXC"),s=a.a.create(),f=["studentToken","teacherToken","adminToken"],m=[],p=a.a.CancelToken,g=function(e){return e.url+"_"+e.method},h=function(e){var n=m.map(function(e){return e.token}).indexOf(g(e));n>-1&&(m[n].cancel(),m.splice(n,1))};s.interceptors.request.use(function(e,n){h(e),e.cancelToken=new p(function(n){m.push({token:g(e),cancel:n})});var t=localStorage.getItem("type");return 0==t?e.headers.studentToken=l.a.getCookie(f[t]):1==t?e.headers.teacherToken=l.a.getCookie(f[t]):2==t&&(e.headers.adminToken=l.a.getCookie(f[t])),e},function(e){return u.a.reject(e)}),s.interceptors.response.use(function(e){e.config.url;if(h(e.config),200101!=e.data.status.code)return e.data;var n=localStorage.getItem("type");n||(n=0),alert("身份认证过期,请重新登陆");i.a.replace({path:["/login","/login1","/login2"][n]})},function(e){if(!e.response)return u.a.reject({msg:"网络连接超时",error:e,code:400});switch(e.response.status){case 401:alert("您没有登录"),i.a.replace({path:"/login"});break;case 403:alert("您没有该操作权限");break;case 500:alert("服务器错误")}return u.a.reject(e.response.data)});var k=function(e,n){var t=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{headers:{"Content-Type":"application/x-www-form-urlencoded"}};return s.post(e,d.a.stringify(n),t)},w=function(e,n){var t=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{headers:{"Content-Type":"application/json"}};return s.post(e,n,t)};t.d(n,"_12",function(){return y}),t.d(n,"_3",function(){return xe}),t.d(n,"_5",function(){return qe}),t.d(n,"m",function(){return Pe}),t.d(n,"N",function(){return Re}),t.d(n,"k",function(){return De}),t.d(n,"M",function(){return Fe}),t.d(n,"_10",function(){return Me}),t.d(n,"W",function(){return Ae}),t.d(n,"H",function(){return Ee}),t.d(n,"O",function(){return Ye}),t.d(n,"h",function(){return Je}),t.d(n,"_1",function(){return Xe}),t.d(n,"_2",function(){return Ge}),t.d(n,"x",function(){return He}),t.d(n,"L",function(){return Le}),t.d(n,"F",function(){return Oe}),t.d(n,"G",function(){return $e}),t.d(n,"d",function(){return Be}),t.d(n,"g",function(){return We}),t.d(n,"v",function(){return Qe}),t.d(n,"_4",function(){return Ve}),t.d(n,"P",function(){return Ze}),t.d(n,"J",function(){return Ue}),t.d(n,"n",function(){return Ke}),t.d(n,"K",function(){return en}),t.d(n,"R",function(){return nn}),t.d(n,"E",function(){return tn}),t.d(n,"l",function(){return rn}),t.d(n,"Q",function(){return un}),t.d(n,"y",function(){return on}),t.d(n,"_11",function(){return an}),t.d(n,"U",function(){return cn}),t.d(n,"f",function(){return dn}),t.d(n,"t",function(){return ln}),t.d(n,"z",function(){return sn}),t.d(n,"o",function(){return fn}),t.d(n,"V",function(){return mn}),t.d(n,"i",function(){return pn}),t.d(n,"u",function(){return gn}),t.d(n,"_8",function(){return hn}),t.d(n,"A",function(){return kn}),t.d(n,"a",function(){return wn}),t.d(n,"Y",function(){return yn}),t.d(n,"p",function(){return bn}),t.d(n,"T",function(){return vn}),t.d(n,"_7",function(){return In}),t.d(n,"s",function(){return Tn}),t.d(n,"e",function(){return Sn}),t.d(n,"S",function(){return jn}),t.d(n,"c",function(){return _n}),t.d(n,"r",function(){return Cn}),t.d(n,"Z",function(){return Nn}),t.d(n,"D",function(){return zn}),t.d(n,"I",function(){return xn}),t.d(n,"j",function(){return qn}),t.d(n,"X",function(){return Pn}),t.d(n,"_9",function(){return Rn}),t.d(n,"w",function(){return Dn}),t.d(n,"C",function(){return Fn}),t.d(n,"b",function(){return Mn}),t.d(n,"_0",function(){return An}),t.d(n,"q",function(){return En}),t.d(n,"B",function(){return Yn}),t.d(n,"_6",function(){return Jn});var y="http://39.105.8.210:8080",b=y+"/teacher/addteacher/",v=y+"/teacher/listteacher/",I=y+"/teacher/updateteacher/",T=y+"/teacher/deleteteacher/",S=y+"/admin/addadmin/",j=y+"/admin/getadminlist/",_=y+"/admin/resetadminpassword/",C=y+"/admin/deleteadmin/",N=y+"/admin/getadminbyid/",z=y+"/admin/updateadmin/",x=y+"/academy/getacademylist/",q=y+"/academy/addacademy/",P=y+"/academy/renameacademy/",R=y+"/academy/deleteacademy/",D=y+"/enrollmentyear/listenrollmentyear/",F=y+"/enrollmentyear/updateenrollmentyear/",M=y+"/enrollmentyear/deleteenrollmentyear/",A=y+"/enrollmentyear/addenrollmentyear/",E=y+"/enrollmentyear/listallenrollmentyear/",Y=y+"/class/addclass/",J=y+"/class/deleteclass/",X=y+"/class/renameclass/",G=y+"/academy/getallacademylist/",H=y+"/class/getclassbyacademyid/",L=y+"/student/liststudent/",O=y+"/student/addstudent/",$=y+"/student/deletestudent/",B=y+"/student/updatestudent/",W=y+"/folder/listfolder/",Q=y+"/folder/addfolder/",V=y+"/folder/deletefolder/",Z=y+"/file/getFileByFolderId/",U=y+"/file/deleteFile/",K=y+"/workproject/getworkprojectlist/",ee=y+"/folder/getallfolder/",ne=y+"/workproject/addworkproject/",te=y+"/workproject/getworkprojectinfo/",re=y+"/workproject/deleteworkproject/",ue=y+"/workproject/updateworkproject/",oe=y+"/workmessage/countstudentunreadmessage/",ae=y+"/processingmethod/getallprocessingmethod/",ie=y+"/surface/getallsurface/",ce=y+"/work/addcraftcardlist/",de=y+"/workmessage/addmessagebystudent/",le=y+"/workmessage/deletestudentmessage/",se=y+"/work/submit/",fe=y+"/work/getworklistbystudentid/",me=y+"/workmessage/getstudentmessage/",pe=y+"/work/getstudentworkinfobyid/",ge=y+"/teaching/getteachingbycreatoridandstatus/",he=y+"/teaching/addteaching/",ke=y+"/teaching/getteachingbyId/",we=y+"/teaching/updateteaching/",ye=y+"/student/liststudentbyparam/",be=y+"/workproject/getallworkprojectlist/",ve=y+"/work/getteacherworkinfobyid/",Ie=y+"/workmessage/addmessagebyteacher/",Te=y+"/work/return/",Se=y+"/work/score/",je=y+"/workmessage/deleteteahcermessage/",_e=y+"/workmessage/getteachermessage/",Ce=y+"/student/login/",Ne=y+"/teacher/login/",ze=y+"/admin/login/",xe=function(e,n){return k(Ce,{name:e,number:n})},qe=function(e,n){return k(Ne,{number:e,password:n})},Pe=function(e,n){return k(ze,{number:e,password:n})},Re=function(e,n,t){return k(ge,{status:e,pageNum:n,pageSize:t})},De=function(e,n,t,r){return w(he,{name:e,teacherReminder:n,deadlineTime:t,works:r})},Fe=function(e){return k(ke,{id:e})},Me=function(e,n,t,r,u){return w(we,{id:e,name:n,teacherReminder:t,deadlineTime:r,works:u})},Ae=function(e,n,t){return k(ye,{enrollmentId:e,academyId:n,classId:t})},Ee=function(){return k(be,{})},Ye=function(e){return k(ve,{id:e})},Je=function(e,n){return k(Ie,{workId:e,content:n})},Xe=function(e){return k(Te,{id:e})},Ge=function(e,n){return k(Se,{id:e,score:n})},He=function(e){return k(je,{id:e})},Le=function(e,n,t){return k(_e,{read:e,pageNum:n,pageSize:t})},Oe=function(){return k(ae,{})},$e=function(){return k(ie,{})},Be=function(e,n){return w(ce,{workId:e,list:n})},We=function(e,n){return k(de,{workId:e,content:n})},Qe=function(e){return k(le,{id:e})},Ve=function(e){return k(se,{id:e})},Ze=function(e,n,t){return k(fe,{isDone:e,pageNum:n,pageSize:t})},Ue=function(e,n,t){return k(me,{read:e,pageNum:n,pageSize:t})},Ke=function(){return k(oe,{})},en=function(e){return k(pe,{id:e})},nn=function(e,n){return k(K,{pageNum:e,pageSize:n})},tn=function(){return k(ee,{})},rn=function(e,n,t){return k(ne,{name:e,desc:n,fileIdList:t})},un=function(e){return k(te,{workProjectId:e})},on=function(e){return k(re,{workProjectId:e})},an=function(e,n,t,r){return k(ue,{id:e,name:n,desc:t,fileIdList:r})},cn=function(e,n){return k(W,{pageNum:e,pageSize:n})},dn=function(e){return k(Q,{name:e})},ln=function(e){return k(V,{id:e})},sn=function(e,n,t){return k(Z,{pageNum:e,pageSize:n,folderId:t})},fn=function(e){return k(U,{id:e})},mn=function(e,n){return k(L,{pageNum:e,pageSize:n})},pn=function(e,n,t,r,u){return k(O,{number:e,name:n,academyId:t,enrollmentId:r,classId:u})},gn=function(e){return k($,{id:e})},hn=function(e,n,t,r,u,o){return k(B,{id:e,number:n,name:t,academyId:r,enrollmentId:u,classId:o})},kn=function(e,n){return k(x,{pageNum:e,pageSize:n})},wn=function(e){return k(q,{name:e})},yn=function(e,n){return k(P,{id:e,name:n})},bn=function(e){return k(R,{id:e})},vn=function(e,n){return k(D,{pageNum:e,pageSize:n})},In=function(e,n){return k(F,{id:e,enrollmentYear:n})},Tn=function(e){return k(M,{id:e})},Sn=function(e){return k(A,{enrollmentYear:e})},jn=function(){return k(E,{})},_n=function(e,n){return k(Y,{academyId:e,name:n})},Cn=function(e){return k(J,{id:e})},Nn=function(e,n){return k(X,{name:e,classId:n})},zn=function(){return k(G,{})},xn=function(e){return k(H,{academyId:e})},qn=function(e,n,t){return k(b,{number:e,name:n,academyId:t})},Pn=function(e,n){return k(v,{pageNum:e,pageSize:n})},Rn=function(e,n,t,r,u){return k(I,{id:e,academyId:n,number:t,name:r,password:u})},Dn=function(e){return k(T,{id:e})},Fn=function(e,n){return k(j,{pageNum:e,pageSize:n})},Mn=function(e,n,t){return k(S,{number:e,name:n,password:t})},An=function(e){return k(_,{id:e})},En=function(e){return k(C,{id:e})},Yn=function(e){return k(N,{id:e})},Jn=function(e,n,t,r){return k(z,{id:e,number:n,name:t,password:r})}},tvR6:function(e,n){}},["NHnr"]);
//# sourceMappingURL=app.a82a21469d3c99f0d29d.js.map