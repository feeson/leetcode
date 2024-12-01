// ==UserScript==
// @name         [] TO {}
// @namespace    http://tampermonkey.net/
// @version      0.1
// @description  try to take over the world!
// @author       You
// @match        https://leetcode.cn/problems/*
// @icon         https://www.google.com/s2/favicons?sz=64&domain=leetcode.cn
// @grant        GM_addStyle
// ==/UserScript==

(function() {
    'use strict';
    // 创建按钮元素
    const textarea = document.createElement('textarea');
    textarea.id = 'mytextarea';
    textarea.innerHTML = "";
    textarea.style.display='none';

    const minimizeBtn=document.createElement('button')
    minimizeBtn.id='minimizebtn';
    minimizeBtn.innerHTML='-';
    minimizeBtn.value="true";

    const infoButton=document.createElement('button');
    infoButton.id='infobtn';
    infoButton.innerHTML='i';
    // 设置按钮样式
    GM_addStyle(`
        #mytextarea {
            position: fixed;
            top: 800px;
            left: 20px;
            z-index: 9999;
            width: 40% !important;
            height: 156px;
           background: rgba(139,114,114,0.3) !important
        }
        #minimizebtn{
            position: fixed;
            top: 800px;
            left:0px;
            z-index:9999;
            width: 20px;
            height: 20px;
            background: rgba(117,181,173,0.8) !important;
            fontsize: 20px;
        }
        #infobtn{
            position: fixed;
            top: 820px;
            left:0px;
            z-index:9999;
            width: 20px;
            height: 20px;
            background: rgba(117,181,173,0.8) !important;
            fontsize: 20px;
        }
    `);

    // 添加按钮到页面
    document.body.appendChild(textarea);
    document.body.appendChild(minimizeBtn);
    document.body.appendChild(infoButton);
    // 添加按钮到页面


    // 添加按钮点击事件处理逻辑
    textarea.addEventListener('change', function() {
        // 处理按钮点击事件
        const textArea = document.getElementById("mytextarea") // 获取匹配的元素
        var text=textArea.value;
        text=text.replaceAll("[","{").replaceAll("]","}")
        textArea.value=text;
    });
    minimizeBtn.addEventListener('click', function() {
        // 处理按钮点击事件
        const minimizebtn = document.getElementById("minimizebtn")
        // 获取匹配的元素
        const textArea = document.getElementById("mytextarea");
        var status=minimizebtn.value;
        if(status=="false"){
            textArea.style.display='none';
            textArea.value="";
            minimizebtn.value='true';
        }else{
            textArea.style.display='block';
            minimizebtn.value='false';
        }
    });
    function trimHtml(htmlNode) {
        return htmlNode.innerHTML.replace(/<[^>]+>/g, '').replaceAll('&nbsp;','').replaceAll("&lt;","<").replaceAll("&gt;",">");
    }
    function trimHtmlKeepSpace(htmlNode) {
        return htmlNode.innerHTML.replace(/<[^>]+>/g, '').replaceAll('&nbsp;',' ').replaceAll("&lt;","<").replaceAll("&gt;",">");
    }
    function spinButton(button){
        // 定义旋转动画
        const rotateAnimation = `
            @keyframes rotate {
                0% { transform: rotate(0deg); }
                50% { transform: rotate(360deg); }
                100% { transform: rotate(720deg); }
            }`;

        // 将动画添加到页面样式中
        const styleElement = document.createElement('style');
        styleElement.innerHTML = rotateAnimation;
        document.head.appendChild(styleElement);

        // 将动画应用到按钮上
        button.style.animation = 'rotate 2s ease-out';

        // 当动画结束时，移除动画
        button.addEventListener('animationend', function() {
            button.style.animation = '';
        });
    }

    infoButton.addEventListener('click',function(){
        var title = document.evaluate('/html/body/div[1]/div[2]/div/div/div[5]/div/div/div[4]/div/div[1]/div[1]/div/div/a',document).iterateNext().innerText;
        var infoDiv = document.evaluate('/html/body/div[1]/div[2]/div/div/div[5]/div/div/div[4]/div/div[1]/div[4]', document).iterateNext();
        var info = trimHtml(infoDiv);

        var href = location.href;
        var codeDiv=document.evaluate('/html/body/div[1]/div[2]/div/div/div[5]/div/div/div[7]/div/div[2]/div[1]/div/div/div[1]/div[2]/div[1]/div[4]', document).iterateNext();
        if (codeDiv == null)
            return
        var lineNodes = codeDiv.childNodes;
        var code = "";
        for (const linediv of lineNodes) {
            var str = trimHtmlKeepSpace(linediv)
            code+=str;
            code+="\n";
        }
        var paste = '/* \n'
            + `${title}\n`
            + `${info}\n`
            + '*/\n'
            + `/*\n`
            + `href: ${href}\n`
            + `*/\n`
            + code;
        navigator.clipboard.writeText(paste).then(function() {
            spinButton(infoButton)
            console.log('文本已成功写入剪切板');
        }, function(err) {
            console.error('无法写入剪切板: ', err);
        });
    });
})();