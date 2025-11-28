const readline = require('readline');
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });

function siptar1(h, w, k){
	let tiles = 0;
	while (h!=0 && w!=0){
		console.log('Entered loop 1!');
		if (h<w){
			w = siptar2(h, w, k);
			console.log('w is now '+w);
		} else {
			h = siptar2(w, h, k);
			console.log('h is now '+h);
		};
	};
	function siptar2(x, y, z){
		let blocks = 0;
		let i = 0;
		let quotient; let remainder;
		let max = 1;
		while (x>0){
			console.log('Entered loop 2!');
			let p = Math.min(Math.floor(Math.log(x)/Math.log(2)),z);
			if (i==0){max = p; quotient = Math.floor(y / 2**p); remainder = y % 2**p;};
			i += 1;
			blocks += 2**(max-p) * Math.floor(x/(2**p));
			x %= 2**p;
		};
		blocks *= quotient;
		tiles += blocks;
		return remainder;
	};
	console.log(tiles);
};

function question(){
	rl.question('Enter h, w, k: ',
	(answer) => {
		let array = answer.split(' ');
		siptar1(Number(array[0]), Number(array[1]), Number(array[2]));
		question();
	});
};

question();

//siptar1(1, 3, 2);

setTimeout(function(){
    process.exit();
}, 86400000);
