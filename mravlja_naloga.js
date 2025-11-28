const readline = require('readline');
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });

function factorial(x){
  if (x <= 1){return 1};
  return x * factorial(x-1);
};

function poti(a, b){
  if (a==1 || b==1){return 1};
  return Number(factorial(a+b-2)/(factorial(a-1)*factorial(b-1)));
};

let sum = 0;
function poti1(a, b, i, j){
  if (a==1 || b==1){return 1;}
  if (i==a-1 && j==b-1){sum += 1; return;}
  if (i<a-1){poti1(a, b, i+1, j);};
  if (j<b-1){poti1(a, b, i, j+1);};
  return sum;
};

function question(){
  rl.question('Enter a, b: ',
  (answer) => {
    let array = answer.split(' ');
    console.log(poti(Number(array[0]), Number(array[1])));
    console.log(poti1(Number(array[0]), Number(array[1]), 0, 0));
    question();
  });
};


question();

setTimeout(function(){
    process.exit();
}, 86400000);
