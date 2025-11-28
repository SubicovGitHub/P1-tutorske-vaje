let piece0 = [
[0,0],
[0,0],
[0,0],
[0,0]
];
let piece1 = [
[0,3]
];
let piece2 = [
[0,1],
[0,1]
];
let piece3 = [
[0,0],
[0,1],
[0,0]
];
let piece4 = [
[1,1],
[0,2]
];
let piece5 = [
[1,1],
[0,1],
[1,1]
];
let piece6 = [
[0,2],
[1,1]
];
let piece7 = [
[0,2],
[1,1]
];
let piece8 = [
[0,0],
[0,0],
[0,1]
];
let piece9 = [
[2,2],
[0,2]
];
let piece10 = [
[0,1],
[1,1],
[1,1]
];
let piece11 = [
[0,0],
[0,2]
];
let piece12 = [
[1,1],
[1,1],
[0,1]
];
let piece13 = [
[0,2],
[2,2]
];
let piece14 = [
[0,1],
[0,0],
[0,0]
];
let piece15 = [
[1,1],
[0,1],
[0,0]
];
let piece16 = [
[0,1],
[1,2]
];
let piece17 = [
[0,0],
[0,1],
[1,1]
];
let piece18 = [
[1,2],
[0,1]
];

let pieces = [piece0, piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8, piece9, piece10, piece11, piece12, piece13, piece14, piece15, piece16, piece17, piece18];

const grid = [];
for (a=-1000; a<=1000; a++){
	grid.push(-1);
};
//console.log(grid);
function drop(piece, w){
	let minDifference = Infinity;
	let minDifferenceI;
	let height;
	//console.log(piece.length);
	for (i=0; i<piece.length; i++){
		if (minDifference>piece[i][0]-grid[i+w+1000]){
			minDifference=piece[i][0]-grid[i+w+1000];
			minDifferenceI = i+w+1000;
		};
		//console.log('i= '+i+', j= '+Number(i+w+1000)+', minDifference= '+minDifference+', minDifferenceI= '+minDifferenceI);
	};
	//console.log('minDifference= '+minDifference+', minDifferenceI= '+minDifferenceI);
	height = grid[minDifferenceI]+1-piece[minDifferenceI-w-1000][0];
	for (k=0; k<piece.length; k++){
		grid[k+w+1000] = height+piece[k][1];
	};
};

function tetris(array){
	for (b=0; b<array.length; b++){
		drop(array[b][0], Number(array[b][1]));
	};
	for (c=0; c<grid.length; c++){
		if (grid[c]!=-1){
			console.log('x= '+Number(c-1000)+', h= '+Number(grid[c]+1));
		};
	};
};

tetris([ [pieces[16], 3], [pieces[4], -3], [pieces[2], 2], [pieces[9], 4], [pieces[10], 0], [pieces[18], -4] ]);

//console.log(pieces[0]);

setTimeout(function(){
    process.exit();
}, 86400000);
