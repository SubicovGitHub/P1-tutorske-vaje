const readline = require('readline');
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });

function imbecile(x){
	for (i=1; i<=x; i++){
		let string = '';
		for (j=1; j<=x-i; j++){
			string += ' ';
			//console.log('j= '+j+', '+string);
		};
		for (k=1; k<=2*i-1; k++){
			string += '*';
			//console.log('k= '+k+', '+string);
		};
		console.log(string);
	};
};

function question(){
	rl.question('Enter number of layers: ',
	(answer) => {
		imbecile(answer);
		question();
	});
};

question();

setTimeout(function(){
    process.exit();
}, 86400000);
