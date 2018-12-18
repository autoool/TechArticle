        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Document</title>
            <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
        </head>
        <body>
            <a  href="img/1.jpg" download='123'>下载本地图片</a>	
            <input class="download-event" type="button" name="下载图片" value="Value" >
    
        </body>
        <script type="text/javascript">
    
            function convertCanvasToImage(imagetype,imageurl) {
                var image = new Image(),
                canvas = document.createElement("canvas");
                ctx = canvas.getContext('2d');
                image.crossOrigin = "Anonymous";
                image.onload= function(){
                    canvas.width = image.width;
                    canvas.height = image.height;
                    ctx.drawImage(image, 0, 0);
                    downloadImage(imagetype,canvas);
                }
                image.src = imageurl;
            }
    
            function downloadImage(imageType,canvas){
                var imgdata = canvas.toDataURL(imageType);
                    //将mime-type改为image/octet-stream,强制让浏览器下载
                var fixtype = function (type) {
                    type = type.toLocaleLowerCase().replace(/jpg/i, 'jpeg');
                    var r = type.match(/png|jpeg|bmp|gif/)[0];
                    return 'image/' + r;
                }
                imgdata = imgdata.replace(fixtype(imageType), 'image/octet-stream')
                //将图片保存到本地
                var saveFile = function (data, filename) {
                    var link = document.createElement('a');
                    link.href = data;
                    link.download = filename;
                    var event = document.createEvent('MouseEvents');
                    event.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
                    link.dispatchEvent(event);
                }
                var filename = new Date().toLocaleDateString() + '.' + imageType;
                saveFile(imgdata, filename);
            }
    
            $('.download-event').on('click',function(){
                var imageType='png';
                var imageUrl = "http://127.0.0.1:8020/jikexueyaun/img/1.jpg";
                convertCanvasToImage(imageType,imageUrl);
            });
        </script>
        </html>