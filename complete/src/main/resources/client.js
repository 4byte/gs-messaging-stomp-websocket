let socket = null;

function bootstrap() {

    let c = document.getElementById('mycanvas');
    let ctx = c.getContext('2d');
    ctx.globalalpha = 0.3;
    for (let i = 0; i < 1000; i++) {
        ctx.beginPath();
        let r = Math.floor(Math.random() * 256);
        let g = Math.floor(Math.random() * 256);
        let b = Math.floor(Math.random() * 256);
        ctx.strokeStyle = 'rgb(' + r + ',' + g + ',' + b + ')';
        ctx.moveTo(Math.random() * 200, Math.random() * 200);
        ctx.lineTo(Math.random() * 200, Math.random() * 200);
        ctx.stroke();
    }

    socket = new WebSocket('ws://localhost:8080/greeting');
    socket.binaryType = 'arraybuffer';
    socket.onopen = function () {
        send(ctx);
    }
    socket.onmessage = handleReceive;
}

function send(ctx) {
    let data = ctx.getImageData(0, 0, 200, 200).data;
    let byteArray = new Uint8Array(data);
    socket.send(byteArray.buffer);
}

function handleReceive(message) {
    let c = resultCanvas = document.getElementById('result');
    let ctx = c.getContext('2d');
    let imageData = ctx.createImageData(200, 200);
    let pixels = imageData.data;

    let buffer = new Uint8Array(message.data);
    for (let i = 0; i < pixels.length; i++) {
        pixels[i] = buffer[i];
    }
    ctx.putImageData(imageData, 0, 0);
}