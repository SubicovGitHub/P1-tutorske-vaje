const readline = require('readline');
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });

function Sieve(x){
  let array = [];
  for (i=2; i<=Math.ceil(x**0.5); i++){
    array.push(i);
  };
  //console.log(array);
  let index = 0;
  while (index <= Math.ceil(x**0.5)-1){
    for (j=index; j<array.length; j += index+2){
      if (j>index){array[j]=0; /*console.log('setting element to zero...');*/};
        //console.log(array); console.log('index: '+index+', j: '+j);
    };
    index += 1;
    while (array[index]==0){index += 1; /*console.log('Incrementing index...');*/};
  };
  //console.log(array);
  index = 0;
  while (index < array.length){
    if (array[index]==0){
      array.splice(index,1);
    } else {
      index += 1;
    };
  };
  //console.log(array);
  return array;
};

function PRIME_FACTORIZATION(a){
  let temp = a;
  let factorization = [];
  let l=0; let c;
  let primes = Sieve(a);
  console.log(primes);
  while (a>=primes[l] && l<primes.length){
    c = 0;
    while (a%primes[l]==0){
      a /= primes[l];
      c++;
    };
    if (c>0){
      factorization.push(primes[l]+'^'+c);
    };
    l += 1;
  };
  if (a>1){factorization.push(a+'^'+1);};
  console.log('Factors of '+temp+': '+factorization);
};

function question(){
  rl.question('Enter number: ',
  (answer) => {
    PRIME_FACTORIZATION(answer);
    question();
  });
};

//question();

PRIME_FACTORIZATION(131400);

setTimeout(function(){
    process.exit();
}, 86400000);
