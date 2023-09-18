package jkfitness.utility;

import java.util.ArrayList;
import java.util.List;

public class ReturnResults {
	
    
        private List<String> StringResults =  new ArrayList<>();
        private List<Integer> IntResults   =  new ArrayList<>();
        private List<Double> DoubleResults =  new ArrayList<>();
        private Boolean FunctionResult   ;
        private List<String> ErrorMsgs     =  new ArrayList<>();


        public List<String> getStringResults() {
			return StringResults;
		}

		public void setStringResults(List<String> stringResults) {
			StringResults = stringResults;
		}

		public List<Integer> getIntResults() {
			return IntResults;
		}

		public void setIntResults(List<Integer> intResults) {
			IntResults = intResults;
		}

		public List<Double> getDoubleResults() {
			return DoubleResults;
		}

		public void setDoubleResults(List<Double> doubleResults) {
			DoubleResults = doubleResults;
		}

		public Boolean getFunctionResult() {
			return FunctionResult;
		}

		public void setFunctionResult(Boolean functionResult) {
			FunctionResult = functionResult;
		}

		public List<String> getErrorMsgs() {
			return ErrorMsgs;
		}

		public void setErrorMsgs(List<String> errorMsgs) {
			ErrorMsgs = errorMsgs;
		}

        
        public void Clear()
        {
        	StringResults.clear();
        	IntResults.clear();
        	DoubleResults.clear();
        	ErrorMsgs.clear();	
        }

}
