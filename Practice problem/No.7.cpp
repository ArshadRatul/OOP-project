#include<iostream>
using namespace std;
class ComplexNo {
private:
    int real, img;
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
}
//represents complex number in the form of “real +/- img i” e.g: 2+3i
class MatrixOfComplexNo {
    int noOfRows;
    int noOfColsForEachRow[noOfRows];
    ComplexNo *complexRowPtr[];
//Array of pointers, simulating matrix of ComplexNo objects
public:
    // add necessary methods including setters and getters,
    // AND/OR declare friends, so that the given main() works
}
int main(){
    int n, row, i;
    MatrixOfComplexNo *matrixPtr;
    matrixPtr = new MatrixOfComplexNo[n];
    cout<<”How many matrices of complex nos? “; cin>>n;
    for(i=0;i<n;i++){
    cin>>matrixPtr[i];
    // ask no of rows for i-th matrix, and then ask no of
    // complexNo for each of the rows of i-th matrix & populate
    // those rows with ComplexNo objects with proper real & img
    }
    cout<<”The matrices of complex numbers is/are: “ << endl;
    showComplexMatrices(matrixPtr, n); //global function
    ComplexNo *mergedRow;
    cout<<”Enter indices of 2 rows of first matrix (<”<<row”) to merge: “;
    cin>>rowIndex1>>rowIndex2;
    mergedRow = matrixPtr[0][rowIndex1].mergeWith(rowIndex2);
    cout<<”The MERGED rows of complex numbers is: “;
    showMergedRow(mergedRow,
    matrixPtr[0].getRowSize(rowIndex1) +
    matrixPtr[0].getRowSize(rowIndex1)
    );
    int lower, upper;
    //get values of lower & upper from user
    // Now display all the Complex numbers from mergedRow,
    // whose real<=lower & img>=upper
    return 0;
}
