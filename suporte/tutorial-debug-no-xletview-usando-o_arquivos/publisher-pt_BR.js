(function (){var k=true,l=null,m=false,o;var p=this;function aa(a,b){a=a.split(".");b=b||p;for(var c;c=a.shift();)if(b[c])b=b[c];else return l;return b}function s(){}
function t(a){var b=typeof a;if(b=="object")if(a){if(a instanceof Array||!(a instanceof Object)&&Object.prototype.toString.call(a)=="[object Array]"||typeof a.length=="number"&&typeof a.splice!="undefined"&&typeof a.propertyIsEnumerable!="undefined"&&!a.propertyIsEnumerable("splice"))return"array";if(!(a instanceof Object)&&(Object.prototype.toString.call(a)=="[object Function]"||typeof a.call!="undefined"&&typeof a.propertyIsEnumerable!="undefined"&&!a.propertyIsEnumerable("call")))return"function"}else return"null";
else if(b=="function"&&typeof a.call=="undefined")return"object";return b}function ba(a){var b=t(a);return b=="array"||b=="object"&&typeof a.length=="number"}function u(a){return typeof a=="string"}function v(a){return t(a)=="function"}function ca(a){a=t(a);return a=="object"||a=="array"||a=="function"}function da(a){if(a.hasOwnProperty&&a.hasOwnProperty(w))return a[w];a[w]||(a[w]=++ea);return a[w]}var w="closure_hashCode_"+Math.floor(Math.random()*2147483648).toString(36),ea=0;
function fa(a){var b=t(a);if(b=="object"||b=="array"){if(a.T)return a.T.call(a);b=b=="array"?[]:{};for(var c in a)b[c]=fa(a[c]);return b}return a}function x(a,b){function c(){}c.prototype=b.prototype;a.R=b.prototype;a.prototype=new c}
var y=Array.prototype,ga=y.indexOf?function(a,b,c){return y.indexOf.call(a,b,c)}:function(a,b,c){c=c==l?0:c<0?Math.max(0,a.length+c):c;if(u(a)){if(!u(b)||b.length!=1)return-1;return a.indexOf(b,c)}for(c=c;c<a.length;c++)if(c in a&&a[c]===b)return c;return-1},ha=y.forEach?function(a,b,c){y.forEach.call(a,b,c)}:function(a,b,c){for(var d=a.length,e=u(a)?a.split(""):a,f=0;f<d;f++)f in e&&b.call(c,e[f],f,a)};
function ia(a){if(t(a)=="array")return a.concat();else{for(var b=[],c=0,d=a.length;c<d;c++)b[c]=a[c];return b}}var ja=/^[a-zA-Z0-9\-_.!~*'()]*$/;function ka(a){a=String(a);if(!ja.test(a))return encodeURIComponent(a);return a}
function z(a,b){if(b)return a.replace(la,"&amp;").replace(ma,"&lt;").replace(na,"&gt;").replace(oa,"&quot;");else{if(!pa.test(a))return a;if(a.indexOf("&")!=-1)a=a.replace(la,"&amp;");if(a.indexOf("<")!=-1)a=a.replace(ma,"&lt;");if(a.indexOf(">")!=-1)a=a.replace(na,"&gt;");if(a.indexOf('"')!=-1)a=a.replace(oa,"&quot;");return a}}var la=/&/g,ma=/</g,na=/>/g,oa=/\"/g,pa=/[&<>\"]/;function qa(a){if(A(a,"&"))return"document"in p&&!A(a,"<")?ra(a):sa(a);return a}
function ra(a){var b=p.document.createElement("a");b.innerHTML=a;b.normalize&&b.normalize();a=b.firstChild.nodeValue;b.innerHTML="";return a}function sa(a){return a.replace(/&([^;]+);/g,function(b,c){switch(c){case "amp":return"&";case "lt":return"<";case "gt":return">";case "quot":return'"';default:if(c.charAt(0)=="#"){c=Number("0"+c.substr(1));if(!isNaN(c))return String.fromCharCode(c)}return b}})}function A(a,b){return a.indexOf(b)!=-1}
function ta(a,b){var c=0;a=String(a).replace(/^[\s\xa0]+|[\s\xa0]+$/g,"").split(".");b=String(b).replace(/^[\s\xa0]+|[\s\xa0]+$/g,"").split(".");for(var d=Math.max(a.length,b.length),e=0;c==0&&e<d;e++){var f=a[e]||"",h=b[e]||"",g=new RegExp("(\\d*)(\\D*)","g"),j=new RegExp("(\\d*)(\\D*)","g");do{var i=g.exec(f)||["","",""],n=j.exec(h)||["","",""];if(i[0].length==0&&n[0].length==0)break;c=B(i[1].length==0?0:parseInt(i[1],10),n[1].length==0?0:parseInt(n[1],10))||B(i[2].length==0,n[2].length==0)||B(i[2],
n[2])}while(c==0)}return c}function B(a,b){if(a<b)return-1;else if(a>b)return 1;return 0}(Date.now||function(){return+new Date})();function ua(a,b,c){for(var d in a)b.call(c,a[d],d,a)}var C,D,E,va,F;function wa(){return p.navigator?p.navigator.userAgent:l}function G(){return p.navigator}(function(){F=va=E=D=C=m;var a;if(a=wa()){var b=G();C=a.indexOf("Opera")==0;D=!C&&a.indexOf("MSIE")!=-1;va=(E=!C&&a.indexOf("WebKit")!=-1)&&a.indexOf("Mobile")!=-1;F=!C&&!E&&b.product=="Gecko"}})();
var xa=C,H=D,ya=F,za=E,I=function(){var a=G();return a&&a.platform||""}();(function(){A(I,"Mac");A(I,"Win");A(I,"Linux");G()&&A(G().appVersion||"","X11")})();var Aa=function(){var a="",b;if(xa&&p.opera){a=p.opera.version;a=typeof a=="function"?a():a}else{if(ya)b=/rv\:([^\);]+)(\)|;)/;else if(H)b=/MSIE\s+([^\);]+)(\)|;)/;else if(za)b=/WebKit\/(\S+)/;if(b)a=(a=b.exec(wa()))?a[1]:""}return a}(),Ba={};function J(){}J.prototype.J=m;J.prototype.z=function(){if(!this.J){this.J=k;this.r()}};
J.prototype.r=function(){};function K(a,b){this.type=a;this.currentTarget=this.target=b}x(K,J);K.prototype.r=function(){delete this.type;delete this.target;delete this.currentTarget};K.prototype.G=m;K.prototype.ga=k;function L(a,b){a&&this.D(a,b)}x(L,K);o=L.prototype;o.target=l;o.relatedTarget=l;o.offsetX=0;o.offsetY=0;o.clientX=0;o.clientY=0;o.screenX=0;o.screenY=0;o.button=0;o.keyCode=0;o.charCode=0;o.ctrlKey=m;o.altKey=m;o.shiftKey=m;o.metaKey=m;o.K=l;
o.D=function(a,b){var c=this.type=a.type;this.target=a.target||a.srcElement;this.currentTarget=b;if(b=a.relatedTarget){if(ya)try{b=b.nodeName&&b}catch(d){b=l}}else if(c=="mouseover")b=a.fromElement;else if(c=="mouseout")b=a.toElement;this.relatedTarget=b;this.offsetX=a.offsetX!==undefined?a.offsetX:a.layerX;this.offsetY=a.offsetY!==undefined?a.offsetY:a.layerY;this.clientX=a.clientX!==undefined?a.clientX:a.pageX;this.clientY=a.clientY!==undefined?a.clientY:a.pageY;this.screenX=a.screenX||0;this.screenY=
a.screenY||0;this.button=a.button;this.keyCode=a.keyCode||0;this.charCode=a.charCode||(c=="keypress"?a.keyCode:0);this.ctrlKey=a.ctrlKey;this.altKey=a.altKey;this.shiftKey=a.shiftKey;this.metaKey=a.metaKey;this.K=a;delete this.ga;delete this.G};H&&(Ba["8"]||(Ba["8"]=ta(Aa,"8")>=0));L.prototype.r=function(){L.R.r.call(this);this.relatedTarget=this.currentTarget=this.target=this.K=l};
function M(a,b){this.N=b;this.k=[];if(a>this.N)throw Error("[goog.structs.SimplePool] Initial cannot be greater than max");for(b=0;b<a;b++)this.k.push(this.e?this.e():{})}x(M,J);M.prototype.e=l;M.prototype.I=l;function Ca(a){if(a.k.length)return a.k.pop();return a.e?a.e():{}}function N(a,b){a.k.length<a.N?a.k.push(b):Da(a,b)}function Da(a,b){if(a.I)a.I(b);else if(v(b.z))b.z();else for(var c in b)delete b[c]}M.prototype.r=function(){M.R.r.call(this);for(var a=this.k;a.length;)Da(this,a.pop());delete this.k};
var Ea,Fa;(function(){Fa=(Ea="ScriptEngine"in p&&p.ScriptEngine()=="JScript")?p.ScriptEngineMajorVersion()+"."+p.ScriptEngineMinorVersion()+"."+p.ScriptEngineBuildVersion():"0"})();var O=Ea,Ga=Fa;function Ha(){}var Ia=0;o=Ha.prototype;o.key=0;o.v=m;o.H=m;o.D=function(a,b,c,d,e,f){if(v(a))this.M=k;else if(a&&a.handleEvent&&v(a.handleEvent))this.M=m;else throw Error("Invalid listener argument");this.F=a;this.P=b;this.src=c;this.type=d;this.capture=!!e;this.X=f;this.H=m;this.key=++Ia;this.v=m};
o.handleEvent=function(a){if(this.M)return this.F.call(this.X||this.src,a);return this.F.handleEvent.call(this.F,a)};var P,Q,R,Ja,S,T,U,Ka;
(function(){function a(){return{p:0,u:0}}function b(){return[]}function c(){function q(Za){return h.call(q.src,q.key,Za)}return q}function d(){return new Ha}function e(){return new L}var f=O&&!(ta(Ga,"5.7")>=0),h;Ja=function(q){h=q};if(f){P=function(q){N(g,q)};Q=function(){return Ca(j)};R=function(q){N(j,q)};S=function(){N(i,c())};T=function(q){N(n,q)};U=function(){return Ca(r)};Ka=function(q){N(r,q)};var g=new M(0,600);g.e=a;var j=new M(0,600);j.e=b;var i=new M(0,600);i.e=c;var n=new M(0,600);n.e=
d;var r=new M(0,600);r.e=e}else{P=s;Q=b;T=S=R=s;U=e;Ka=s}})();var V={},W={},La={},Ma={};function Na(a){if(!V[a])return m;var b=V[a];if(b.v)return m;var c=b.src,d=b.type,e=b.P,f=b.capture;if(c.removeEventListener){if(c==p||!c.ma)c.removeEventListener(d,e,f)}else c.detachEvent&&c.detachEvent(Oa(d),e);c=da(c);e=W[d][f][c];if(La[c]){var h=La[c],g=ga(h,b);g>=0&&y.splice.call(h,g,1).length==1;h.length==0&&delete La[c]}b.v=k;e.O=k;Pa(d,f,c,e);delete V[a];return k}
function Pa(a,b,c,d){if(!d.A)if(d.O){for(var e=0,f=0;e<d.length;e++)if(d[e].v){var h=d[e].P;h.src=l;S(h);T(d[e])}else{if(e!=f)d[f]=d[e];f++}d.length=f;d.O=m;if(f==0){R(d);delete W[a][b][c];W[a][b].p--;if(W[a][b].p==0){P(W[a][b]);delete W[a][b];W[a].p--}if(W[a].p==0){P(W[a]);delete W[a]}}}}function Oa(a){if(a in Ma)return Ma[a];return Ma[a]="on"+a}
function Qa(a,b,c,d,e){var f=1;b=da(b);if(a[b]){a.u--;a=a[b];if(a.A)a.A++;else a.A=1;try{for(var h=a.length,g=0;g<h;g++){var j=a[g];if(j&&!j.v)f&=Ra(j,e)!==m}}finally{a.A--;Pa(c,d,b,a)}}return Boolean(f)}function Ra(a,b){b=a.handleEvent(b);a.H&&Na(a.key);return b}
Ja(function(a,b){if(!V[a])return k;a=V[a];var c=a.type,d=W;if(!(c in d))return k;d=d[c];var e,f;if(H){e=b||aa("window.event");b=k in d;var h=m in d;if(b){if(e.keyCode<0||e.returnValue!=undefined)return k;a:{var g=m;if(e.keyCode==0)try{e.keyCode=-1;break a}catch(j){g=k}if(g||e.returnValue==undefined)e.returnValue=k}}g=U();g.D(e,this);e=k;try{if(b){for(var i=Q(),n=g.currentTarget;n;n=n.parentNode)i.push(n);f=d[k];f.u=f.p;for(var r=i.length-1;!g.G&&r>=0&&f.u;r--){g.currentTarget=i[r];e&=Qa(f,i[r],c,
k,g)}if(h){f=d[m];f.u=f.p;for(r=0;!g.G&&r<i.length&&f.u;r++){g.currentTarget=i[r];e&=Qa(f,i[r],c,m,g)}}}else e=Ra(a,g)}finally{if(i){i.length=0;R(i)}g.z();Ka(g)}return e}f=new L(b,this);try{e=Ra(a,f)}finally{f.z()}return e});function Sa(a){if(a[1]){var b=a[0],c=b.indexOf("#");if(c>=0){a.push(b.substr(c));a[0]=b=b.substr(0,c)}c=b.indexOf("?");if(c<0)a[1]="?";else if(c==b.length-1)a[1]=undefined}return a.join("")}var Ta=/#|$/;
function Ua(a,b){var c=a.search(Ta),d;a:{d=0;for(var e=b.length;(d=a.indexOf(b,d))>=0&&d<c;){var f=a.charCodeAt(d-1);if(f==38||f==63){f=a.charCodeAt(d+e);if(!f||f==61||f==38||f==35){d=d;break a}}d+=e+1}d=-1}if(d<0)return l;else{e=a.indexOf("&",d);if(e<0||e>c)e=c;d+=b.length+1;return decodeURIComponent(a.substr(d,e-d).replace(/\+/g," "))}}
function Va(a,b){ua(b,function(c,d){if(d=="style")a.style.cssText=c;else if(d=="class")a.className=c;else if(d=="for")a.htmlFor=c;else if(d in Wa)a.setAttribute(Wa[d],c);else a[d]=c})}var Wa={cellpadding:"cellPadding",cellspacing:"cellSpacing",colspan:"colSpan",rowspan:"rowSpan",valign:"vAlign",height:"height",width:"width",usemap:"useMap",frameborder:"frameBorder",type:"type"};
function Xa(a,b){var c=b[0],d=b[1];if(H&&d&&(d.name||d.type)){c=["<",c];d.name&&c.push(' name="',z(d.name),'"');if(d.type){c.push(' type="',z(d.type),'"');d=fa(d);delete d.type}c.push(">");c=c.join("")}var e=a.createElement(c);if(d)if(u(d))e.className=d;else Va(e,d);if(b.length>2){d=function(h){if(h)e.appendChild(u(h)?a.createTextNode(h):h)};for(c=2;c<b.length;c++){var f=b[c];ba(f)&&!(ca(f)&&f.nodeType>0)?ha(Ya(f)?ia(f):f,d):d(f)}}return e}function X(){return Xa(document,arguments)}
function Ya(a){if(a&&typeof a.length=="number")if(ca(a))return typeof a.item=="function"||typeof a.item=="string";else if(v(a))return typeof a.item=="function";return m}function Y(a){this.a=O?[]:"";a!=l&&this.append.apply(this,arguments)}
if(O){Y.prototype.C=0;Y.prototype.append=function(a,b){if(b==l)this.a[this.C++]=a;else{this.a.push.apply(this.a,arguments);this.C=this.a.length}return this}}else Y.prototype.append=function(a,b){this.a+=a;if(b!=l)for(var c=1;c<arguments.length;c++)this.a+=arguments[c];return this};Y.prototype.clear=function(){if(O)this.C=this.a.length=0;else this.a=""};Y.prototype.toString=function(){if(O){var a=this.a.join("");this.clear();a&&this.append(a);return a}else return this.a};
function $a(a,b,c){a=a||document;c=c&&c!="*"?c.toLowerCase():"";if(a.querySelectorAll&&(c||b)&&(!za||1))b=a.querySelectorAll(c+(b?"."+b:""));else if(b&&a.getElementsByClassName){a=a.getElementsByClassName(b);if(c){for(var d={},e=0,f=0,h;h=a[f];f++)if(c==h.nodeName.toLowerCase())d[e++]=h;d.length=e;b=d}else b=a}else{a=a.getElementsByTagName(c||"*");if(b){d={};for(f=e=0;h=a[f];f++){c=h.className;if(typeof c.split=="function"&&ga(c.split(" "),b)>=0)d[e++]=h}d.length=e;b=d}else b=a}if(b.length>=1)return b[0];
else throw Error();}function ab(a){return document.createTextNode(a)}function bb(a,b){if(b instanceof Array){for(var c=0;c<b.length;c++)a=a.replace("%"+(c+1),b[c]);return a}else return a.replace("%1",b)}var cb=new RegExp("<(/s*(blockquote|body|center|dd|dir|div|dl|dt|form|h1|h2|h3|h4|h5|h6|head|html|hr|isindex|li|menu|noframes|ol|p|table|td|th|tr|title|ul)[^>]*|s*br[^>]*)>","gi"),db=/<[^>]*>/gi,eb=/</g,fb=/>/g;
function gb(a,b){if(!a)return"";if(b)a=a.replace(cb," ");a=a.replace(db,"");return a.replace(eb,"&lt;").replace(fb,"&gt;")}function hb(a,b){if(a.length<=b)return a;var c=a.split(/\s+/);a=[];for(var d=0,e=0;e<c.length&&d<=b;e++){a.push(c[e]);d+=c[e].length+(e?1:0)}a=a.join(" ");if(e!=c.length)a+="...";return a}var ib={};function jb(a){a in ib||(ib[a]=Ua(window.location.search,a));return ib[a]}
function kb(a){if(jb("hl"))a=Sa([a,"&","hl","=",ka("pt_BR")]);var b=jb("gl");if(b)a=Sa([a,"&","gl","=",ka(b)]);return a}
var Z={},lb={blue:{j:"#fff",i:"#bccceb",o:"#090992",m:"#bccceb",l:"#1010c8",g:"#7a7ee0",h:"#e5ecf9",f:"#898de9"},green:{j:"#fff",i:"#d8dbbc",o:"#2d8509",m:"#d8dbbc",l:"#58bf2f",g:"#97e07a",h:"#f5fbeb",f:"#adb094"},slate:{j:"#123",i:"#345",o:"#5e805e",m:"#5e6f80",l:"#abc",g:"#5e6f80",h:"#152939",f:"#abc"},gray:{j:"#fff",i:"#ccc",o:"#666",m:"#ccc",l:"#999",g:"#ccc",h:"#eee",f:"#aaa"},khaki:{j:"#f2e9ca",i:"#8e7c6a",o:"#d52",m:"#cba",l:"#543",g:"#ba9",h:"#eae0c6",f:"#987"},pink:{j:"#fff",i:"#aaa",o:"#d69",
m:"#ddd",l:"#e684ad",g:"#ebc",h:"#fcf0f7",f:"#a88"},black:{j:"#000",i:"#aaa",o:"#ccc",m:"#d8dbbc",l:"#d52",g:"#7a2b0e",h:"#111",f:"#999"}},mb={margin:0,padding:0,background:"transparent none",border:"none",textAlign:"left",textIndent:"0",textDecoration:"none",fontWeight:"normal"};
function nb(a,b){"GRC_c"in window||(window.GRC_c=0);this.B="readerpublishermodule"+window.GRC_c++;this.d=a;this.Q=Z.c;this.S=Z.t;this.ja=Z.s=="true";this.L=Z.b=="true";this.ia=Z.n=="true";this.ka=Z.w=="true";if(b){b.innerHTML="";b.id=this.B;ob(this,document.getElementById(this.B))}else{document.write('<div id="'+this.B+'" class="reader-publisher-module"></div>');var c=this;window.setTimeout(function(){ob(c,document.getElementById(c.B))},0)}}function pb(a){Z=a}
function ob(a,b){var c=qb(a);$(a,c.fa,b);if(a.S){var d=X("h3");$(a,c.ea,d);d.appendChild(ab(a.S));b.appendChild(d)}d=X("ul");$(a,c.da,d);for(var e=0,f;f=a.d.items[e];e++)if(f.alternate){var h=X("li");$(a,c.ca,h);var g=X("a",{href:f.alternate.href,title:f.title,"class":"i"});$(a,c.$,g);var j=gb(f.title||f.content);/^[\s\xa0]*$/.test(j==l?"":String(j))||(j=hb(j,48));g.appendChild(ab(j));h.appendChild(g);if(a.ja&&!a.L&&f.origin.title){var i=f.origin;g=X("div",{"class":"s"});$(a,c.ba,g);h.appendChild(g);
j=i.title;if(j.length>48)j=j.substring(0,48);g.innerHTML=bb("do <a>%1</a>",j);if(i.htmlUrl){i=X("a",{href:i.htmlUrl});i.innerHTML=j;$(a,c.aa,i);g.replaceChild(i,g.getElementsByTagName("a")[0])}}if(a.ia&&!a.L){g="";f=f.annotations||[];for(j=0;i=f[j];j++)if(A(a.d.id,i.userId)&&i.content.length>0){g=i.content;break}if(g.length>0){f=X("div");$(a,c.Z,f);if(g.length>48)g=g.substring(0,48);f.innerHTML='"'+g+'"';h.appendChild(f)}}d.appendChild(h)}b.appendChild(d);d=X("div",{"class":"f"});$(a,c.W,d);if(a.ka){e=
X("a",{href:"http://www.google.com/webelements"});$(a,c.la,e);d.appendChild(e)}if(a.d.id){e=a.d.id.search(/^user\/(\d+)\/bundle\//)!=-1;h=a.d.id.indexOf("feed/")==0;f=a.d.alternate&&a.d.alternate.href;if(!h||e||f){f=X("a");$(a,c.f,f);f.appendChild(ab(qa("Visualizar tudo &raquo;")));if(e){var n=kb("http://www.google.com/reader/bundle/"+a.d.id);e=rb({Y:n,ha:"Visualizar &raquo;"});d.appendChild(e);$(a,c.V,$a(e,"gr-bundle-table"));$(a,c.U,$a(e,"gr-show-all"));$a(e,"gr-subscribe-button").onclick=function(){window.location.href=
n}}else{f.href=h?a.d.alternate.href:kb("http://www.google.com/reader/shared/"+a.d.id);d.appendChild(f)}}}b.appendChild(d)}
function qb(a){if(a.Q=="-")return{};a=lb[a.Q];return{fa:{fontFamily:"arial, sans-serif",fontSize:"10pt",background:a.j,border:"solid 1px "+a.i,margin:"0.5em"},ea:{padding:"0.2em 0.5em",background:a.h,borderBottom:"solid 1px "+a.m,color:a.o},da:{padding:"0.2em",margin:"0 0.5em",overflow:"hidden"},ca:{listStyleType:"none",padding:"0.4em 0 0.4em 0"},$:{color:a.l,borderBottom:"solid 1px "+a.g},ba:{color:a.g},aa:{color:a.g},Z:{color:"#777",fontStyle:"italic"},W:{textAlign:"right",borderTop:"solid 1px "+
a.i,background:a.h,padding:"0.2em 8px",fontSize:"small",whiteSpace:"nowrap",overflow:"hidden"},f:{color:a.f,textDecoration:"underline"},V:{width:"100%"},U:{textAlign:"right"},la:{cssFloat:"left",styleFloat:"left",display:"block",width:"130px",height:"20px",background:H&&Aa<7?"none":"url(http://www.google.com/reader/ui/web-elements-logo.png)",filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(src=http://www.google.com/reader/ui/web-elements-logo.png,sizingMethod=crop)"}}}
function $(a,b,c){if(b){for(var d in mb)c.style[d]=mb[d];for(var e in b)c.style[e]=b[e]}}window.GRC_p=pb;window.GRC=nb;function rb(a,b){var c=b||new Y;c.append('<div><table class="gr-bundle-table"><tr><td><input class="gr-subscribe-button" type="button" value="',"Inscrever-se",'"></td><td class="gr-show-all"><a href="',z(String(a.Y)),'">',a.ha,"</a></td></tr></table></div>");if(!b){b=c.toString();c=document;a=c.createElement("div");a.innerHTML=b;if(a.childNodes.length==1)a=a.firstChild;else{for(b=c.createDocumentFragment();a.firstChild;)b.appendChild(a.firstChild);a=b}return a}};})();