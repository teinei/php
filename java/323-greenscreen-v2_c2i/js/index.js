var fgimg = null;
var bgimg=null;

function charToInt(){
    var char=document.getElementById('c2iTxt').value;
    var int = char.charCodeAt(0);
    alert(int);
}

function loadForegroundImage() {
    fgimg=new SimpleImage(fgfile);
    fgimg.drawTo(fgcan);
}
function loadBackgroundImage() {
    bgimg=new SimpleImage(bgfile);
    bgimg.drawTo(bgcan);
}

function createComposite(){
    var output=new SimpleImage(fgimg.getWidth(),fgimg.getHeight());
    var greenThreshold = 240;
    for(var pixel of fgimg.values()){
        var x = pixel.getX();
        var y=pixel.getY();
        if (pixel.getGreen()>greenThreshold){
            var bgPixel = bgimg.getPixel(x,y);
            output.setPixel(x,y,bgPixel);
        }else{
            output.setPixel(x,y,pixel);
        }
    }
    return output;
}
function doGreenScreen(){
    if(fgimg == null||!fgimg.complete() ){
        alert("Foreground image not loaded");
    }
    if(bgimg==null||!bgimg.complete()){
        alert("background image not loaded");
    }
    var finalimg = createComposite();
    finalimg.drawTo(fgcan);
}
