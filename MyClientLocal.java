import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class MyClientLocal {
	
	//Static variables for partial output printing.
	public static int totalLinesInCurrentOutuputFile = 0;
	public static int currentOutputFileNumber = 1;
	public static String outputFileName = "";
	public static ArrayList<String> outputTemporaryText = new ArrayList<String>();
	
	//Static variables for edge color storage.
	public static HashMap<String, HashMap<ArrayList<String>, String>> allTheMaps = new HashMap<>();
	public static HashMap<String, Stack<ArrayList<String>>> gapsThatWork = new HashMap<>();
	
	//Example points we used for a specific edge color combination.
	//Modified depending on the edge colors. 
	public static String[] allViewpointsConsideredForCurrentCase = { "BDEFGI", "BCFG", "ACEI", "BDEG", "ACEG", "ACDG", "ABDFH", "CEGI", "ACFI", "BCEGI", "ACDFH", "BDEGI", "ACEFH", "BDFGI", "ACEGH", "BDFHI", "ACEGI", "ACDEHI", "ACEFGH", "ABCHI", "ACEFGI", "BCEH", "BCEG", "BDGH", "ADFH", "BEGI", "ACFH", "BDGI", "ACEH", "BDFI", "BDFH", "ADEFG", "ACDGH", "ADEFH", "ADFHI", "BCEF", "ABFG", "ABDEGHI", "ABCEFH", "BFGHI", "ABCFHI", "ABCEFI", "ABCEFG", "ABCDGHI", "ACDEGH", "ABCGH", "ACEGHI", "ACGH", "ABEG", "CFGI", "ADFGH", "ACEHI", "ABEF", "ABDEFGH", "ABCDEH", "ABCEGI", "ABDGHI", "ABCDEF", "ABCDEG", "ABCEGH", "ABCFI", "ABCFH", "ABDHI", "ABCFG", "ABEFGHI", "ACFGHI", "CDFI", "CDFH", "ACDEG", "ACDEH", "ADGHI", "BCGH", "CDFG", "BEFGI", "BEFGH", "ABCDFG", "ABDFGH", "ABCDFH", "ABCEHI", "ABCEI", "ABCEH", "ABCEG", "ABDGH", "ACEFHI", "ABCEF", "BCFH", "ACEFG", "ACFHI", "ACEFI", "ABGH", "BCDFGHI", "ABCDGH", "ABDEFH", "ABDFHI", "ABDEFG", "ACDGHI", "ADEFGH", "DEGI", "AFGHI", "DEGH", "BDEFGH", "ADEGHI", "CDGI", "AEFHI", "CDGH", "BCDFGI", "BCDFGH", "ACDEFG", "ACDEFH", "ACDFHI", "ADEHI", "AEFGH", "ABCGHI", "ADFGHI", "ACDFGH", "ADEFHI", "ADEGH", "ACDHI", "ABCFGH", "ABCFGI", "CDEGH", "CDEGI", "ABGHI", "ACDEFGH", "BCFGI", "BCEFGH", "BCFGH", "BCEFGI", "CEFGI", "ACDEFHI", "ABCEFHI", "ACDFGHI", "AEFH", "BCDEFI", "BCDEFG", "BCDEFH", "BCDFHI", "AEFGHI", "BDFGHI", "CFGHI","ABCFGHI", "BCDEGH", "BCDEGI", "CDEFGI", "CDEFGH", "ABCEGHI", "ABEHI", "ABCDG", "ABCDF", "ABDFG", "ABCDEGH", "ABCDE", "BFGI", "ACFGH", "ACFGI", "BCDGI", "BDEFH", "BDEFI", "BCDGH", "ABEGHI", "ABCDHI", "ABCEFGI", "ABDEG", "ABDEF", "ABCEFGH", "ABCDEHI", "BCDEFGI", "ADEG", "BCDEFGH", "ADEH", "ACGHI", "ADEFGHI", "BCDFH", "BDFGH", "BCDFI", "BCDFG", "DEFGI", "DEFGH", "ABEFGH", "ABDEHI", "CDFGHI", "CDFGH", "ABCDFGH", "CDFGI", "ABEFH", "ABEFG", "ACFG", "ABDF", "ABDG", "ABDE", "ABDEFHI", "BCEGH", "BCDEG", "BCDEH", "BCFGHI", "BCDEF", "ABEFHI", "ACEFGHI", "CDEFG", "CDFHI", "CDEFH", "ABCDEFH", "CDEFI", "ABFGH", "ABCDFHI", "ABCDEFG", "ADGH", "BEFI", "BEFH",  "ACDEGHI", "ABFGHI", "ABDFGHI", "BCEFG", "BCEFH",	"ACDEGI", "ACDFI", "ABCDEI", "ACDEI", "ABCDFI", "ABCDGI", "ACDEFI", "ACDEFGI", "ABCDI",  "ABCDEGI", "ACDI", "ABCDFGI", "ABCDEFI", "ADEFI", "ABDGI", "ABDEFGI", "ABDFGI", "ABDEFI", "ADEFGI", "AEFGI", "ADEGI", "AEFI", "AFGI", "ABDFI", "ADFI", "ABDEGI", "ABDEI", "ABEGI", "ADEI", "ABEFGI", "ABEFI", "ABFGI", "BDEFGHI", "DEFGHI", "BEHI", "BEFHI", "EFGHI", "CEHI", "BDEHI", "BEGHI", "CDEFGHI", "BDEFHI", "BDEGHI", "EFHI", "DEHI", "BEFGHI", "CEGHI", "CEFGHI", "BCDEHI", "CDEHI", "CDEGHI", "BCEGHI", "BCDEFHI", "DEGHI", "CDEFHI", "BCEHI", "BCDEGHI", "DEFHI", "BCEFGHI", "BCHI", "BDHI", "BCDHI", "CDHI", "BCDGHI", "BCGHI", "CDGHI",  "BDGHI"	};
	public static String[] allOfTheViewpoints = {"HI", "GI", "GH", "GHI", "FI", "FH", "FHI", "FG", "FGI", "FGH", "FGHI", "EI", "EH", "EHI", "EG", "EGI", "EGH", "EGHI", "EF", "EFI", "EFH", "EFHI", "EFG", "EFGI", "EFGH", "EFGHI", "DI", "DH", "DHI", "DG", "DGI", "DGH", "DGHI", "DF", "DFI", "DFH", "DFHI", "DFG", "DFGI", "DFGH", "DFGHI", "DE", "DEI", "DEH", "DEHI", "DEG", "DEGI", "DEGH", "DEGHI", "DEF", "DEFI", "DEFH", "DEFHI", "DEFG", "DEFGI", "DEFGH", "DEFGHI", "CI", "CH", "CHI", "CG", "CGI", "CGH", "CGHI", "CF", "CFI", "CFH", "CFHI", "CFG", "CFGI", "CFGH", "CFGHI", "CE", "CEI", "CEH", "CEHI", "CEG", "CEGI", "CEGH", "CEGHI", "CEF", "CEFI", "CEFH", "CEFHI", "CEFG", "CEFGI", "CEFGH", "CEFGHI", "CD", "CDI", "CDH", "CDHI", "CDG", "CDGI", "CDGH", "CDGHI", "CDF", "CDFI", "CDFH", "CDFHI", "CDFG", "CDFGI", "CDFGH", "CDFGHI", "CDE", "CDEI", "CDEH", "CDEHI", "CDEG", "CDEGI", "CDEGH", "CDEGHI", "CDEF", "CDEFI", "CDEFH", "CDEFHI", "CDEFG", "CDEFGI", "CDEFGH", "CDEFGHI", "BI", "BH", "BHI", "BG", "BGI", "BGH", "BGHI", "BF", "BFI", "BFH", "BFHI", "BFG", "BFGI", "BFGH", "BFGHI", "BE", "BEI", "BEH", "BEHI", "BEG", "BEGI", "BEGH", "BEGHI", "BEF", "BEFI", "BEFH", "BEFHI", "BEFG", "BEFGI", "BEFGH", "BEFGHI", "BD", "BDI", "BDH", "BDHI", "BDG", "BDGI", "BDGH", "BDGHI", "BDF", "BDFI", "BDFH", "BDFHI", "BDFG", "BDFGI", "BDFGH", "BDFGHI", "BDE", "BDEI", "BDEH", "BDEHI", "BDEG", "BDEGI", "BDEGH", "BDEGHI", "BDEF", "BDEFI", "BDEFH", "BDEFHI", "BDEFG", "BDEFGI", "BDEFGH", "BDEFGHI", "BC", "BCI", "BCH", "BCHI", "BCG", "BCGI", "BCGH", "BCGHI", "BCF", "BCFI", "BCFH", "BCFHI", "BCFG", "BCFGI", "BCFGH", "BCFGHI", "BCE", "BCEI", "BCEH", "BCEHI", "BCEG", "BCEGI", "BCEGH", "BCEGHI", "BCEF", "BCEFI", "BCEFH", "BCEFHI", "BCEFG", "BCEFGI", "BCEFGH", "BCEFGHI", "BCD", "BCDI", "BCDH", "BCDHI", "BCDG", "BCDGI", "BCDGH", "BCDGHI", "BCDF", "BCDFI", "BCDFH", "BCDFHI", "BCDFG", "BCDFGI", "BCDFGH", "BCDFGHI", "BCDE", "BCDEI", "BCDEH", "BCDEHI", "BCDEG", "BCDEGI", "BCDEGH", "BCDEGHI", "BCDEF", "BCDEFI", "BCDEFH", "BCDEFHI", "BCDEFG", "BCDEFGI", "BCDEFGH", "BCDEFGHI", "AI", "AH", "AHI", "AG", "AGI", "AGH", "AGHI", "AF", "AFI", "AFH", "AFHI", "AFG", "AFGI", "AFGH", "AFGHI", "AE", "AEI", "AEH", "AEHI", "AEG", "AEGI", "AEGH", "AEGHI", "AEF", "AEFI", "AEFH", "AEFHI", "AEFG", "AEFGI", "AEFGH", "AEFGHI", "AD", "ADI", "ADH", "ADHI", "ADG", "ADGI", "ADGH", "ADGHI", "ADF", "ADFI", "ADFH", "ADFHI", "ADFG", "ADFGI", "ADFGH", "ADFGHI", "ADE", "ADEI", "ADEH", "ADEHI", "ADEG", "ADEGI", "ADEGH", "ADEGHI", "ADEF", "ADEFI", "ADEFH", "ADEFHI", "ADEFG", "ADEFGI", "ADEFGH", "ADEFGHI", "AC", "ACI", "ACH", "ACHI", "ACG", "ACGI", "ACGH", "ACGHI", "ACF", "ACFI", "ACFH", "ACFHI", "ACFG", "ACFGI", "ACFGH", "ACFGHI", "ACE", "ACEI", "ACEH", "ACEHI", "ACEG", "ACEGI", "ACEGH", "ACEGHI", "ACEF", "ACEFI", "ACEFH", "ACEFHI", "ACEFG", "ACEFGI", "ACEFGH", "ACEFGHI", "ACD", "ACDI", "ACDH", "ACDHI", "ACDG", "ACDGI", "ACDGH", "ACDGHI", "ACDF", "ACDFI", "ACDFH", "ACDFHI", "ACDFG", "ACDFGI", "ACDFGH", "ACDFGHI", "ACDE", "ACDEI", "ACDEH", "ACDEHI", "ACDEG", "ACDEGI", "ACDEGH", "ACDEGHI", "ACDEF", "ACDEFI", "ACDEFH", "ACDEFHI", "ACDEFG", "ACDEFGI", "ACDEFGH", "ACDEFGHI", "AB", "ABI", "ABH", "ABHI", "ABG", "ABGI", "ABGH", "ABGHI", "ABF", "ABFI", "ABFH", "ABFHI", "ABFG", "ABFGI", "ABFGH", "ABFGHI", "ABE", "ABEI", "ABEH", "ABEHI", "ABEG", "ABEGI", "ABEGH", "ABEGHI", "ABEF", "ABEFI", "ABEFH", "ABEFHI", "ABEFG", "ABEFGI", "ABEFGH", "ABEFGHI", "ABD", "ABDI", "ABDH", "ABDHI", "ABDG", "ABDGI", "ABDGH", "ABDGHI", "ABDF", "ABDFI", "ABDFH", "ABDFHI", "ABDFG", "ABDFGI", "ABDFGH", "ABDFGHI", "ABDE", "ABDEI", "ABDEH", "ABDEHI", "ABDEG", "ABDEGI", "ABDEGH", "ABDEGHI", "ABDEF", "ABDEFI", "ABDEFH", "ABDEFHI", "ABDEFG", "ABDEFGI", "ABDEFGH", "ABDEFGHI", "ABC", "ABCI", "ABCH", "ABCHI", "ABCG", "ABCGI", "ABCGH", "ABCGHI", "ABCF", "ABCFI", "ABCFH", "ABCFHI", "ABCFG", "ABCFGI", "ABCFGH", "ABCFGHI", "ABCE", "ABCEI", "ABCEH", "ABCEHI", "ABCEG", "ABCEGI", "ABCEGH", "ABCEGHI", "ABCEF", "ABCEFI", "ABCEFH", "ABCEFHI", "ABCEFG", "ABCEFGI", "ABCEFGH", "ABCEFGHI", "ABCD", "ABCDI", "ABCDH", "ABCDHI", "ABCDG", "ABCDGI", "ABCDGH", "ABCDGHI", "ABCDF", "ABCDFI", "ABCDFH", "ABCDFHI", "ABCDFG", "ABCDFGI", "ABCDFGH", "ABCDFGHI", "ABCDE", "ABCDEI", "ABCDEH", "ABCDEHI", "ABCDEG", "ABCDEGI", "ABCDEGH", "ABCDEGHI", "ABCDEF", "ABCDEFI", "ABCDEFH", "ABCDEFHI", "ABCDEFG", "ABCDEFGI", "ABCDEFGH", "ABCDEFGHI"};	
	public static ArrayList<String> listOfAllViewpoints;
	
	public static void main(String[] args) throws Exception{
		if(args.length==1){
			outputFileName = args[0];
			new RunIt().start();
		} else{
			System.out.println("Name of case required as only command line argument.");
		}
	}	
	
	public static ArrayList<String> updateGapsForAllPoints(ArrayList<String> ordering, ArrayList<String> usableViewpoints, HashMap<ArrayList<String>, String> edgeColor, ArrayList<String> importantPoints){
		String key = usableViewpoints.get(0);
		if(!gapsThatWork.containsKey(key)){
			return initializeGapsThatWork(ordering, edgeColor, importantPoints, usableViewpoints);			
		}
		
		int startingStackSize = gapsThatWork.get(key).size();
		int bigThreshold = 900;
		
		boolean addedPointToOrder = true;
		while(addedPointToOrder){
			addedPointToOrder = false;			
			for(int i=0; i<usableViewpoints.size(); i++){				
				String thisPoint = usableViewpoints.get(i);
				if(ordering.contains(thisPoint))
				continue;
				
				Stack<ArrayList<String>> stackForThisPoint = gapsThatWork.get(thisPoint);
				ArrayList<String> gapsThatWorkedBefore;
				if(stackForThisPoint.size() > startingStackSize){
					gapsThatWorkedBefore = stackForThisPoint.pop();
				}else{
					gapsThatWorkedBefore = stackForThisPoint.peek();
				}				
				ArrayList<String> updatedGaps = new ArrayList<String>();
				
				if(gapsThatWorkedBefore.get(0).equals("Big")){
					updatedGaps.add("Big");
					updatedGaps.add("ManyViewpoints");
					gapsThatWork.get(thisPoint).push(updatedGaps);
					continue;
				}
				
				int j = -1;
				int oldGapIndex = 0;
				String currentLeftPoint = "-infty";
				
				boolean foundTrivialGapForThisPoint = false;
				
				lookingForGapsLoop:
				while(j<ordering.size()-1 && oldGapIndex < gapsThatWorkedBefore.size()){					
					String oldGap = gapsThatWorkedBefore.get(oldGapIndex);
					String oldGapLeftPoint = oldGap.substring(0,oldGap.indexOf(':'));
					String oldGapRightPoint = oldGap.substring(oldGap.indexOf(':')+1);
					
					while(!currentLeftPoint.equals(oldGapLeftPoint)){
						j++;
						currentLeftPoint = ordering.get(j);
					}
					
					String currentRightPoint;
					do{						
						currentRightPoint = ordering.get(j+1);
						if(gapIsTrivialToLeft(currentLeftPoint, thisPoint, ordering, j, edgeColor) || gapIsTrivialToRight(thisPoint, currentRightPoint, ordering, j+1, edgeColor)){
							//We want it to go in this gap.
							updatedGaps.clear();
							updatedGaps.add(currentLeftPoint+":"+currentRightPoint);
							foundTrivialGapForThisPoint = true;
							break lookingForGapsLoop;
						}
						
						//If the gap isn't trivial for this point, we don't want to insert it here if this gap is trivial for currentLeft and currentRight.
						if(!gapIsTrivialToLeft(currentLeftPoint, currentRightPoint, ordering, j, edgeColor) && !gapIsTrivialToRight(currentLeftPoint, currentRightPoint, ordering, j+1, edgeColor)){
							HashMap<ArrayList<String>, String> copyOfEdgeColors = new HashMap<ArrayList<String>, String>(edgeColor);
							ArrayList<String> newOrdering = new ArrayList<String>();
							newOrdering.clear();
							newOrdering.addAll(ordering);
							newOrdering.add(j+1, usableViewpoints.get(i));
							
							for(int k=0; k<newOrdering.size(); k++){
								if(k==j+1){
									continue;
								}
								
								ArrayList<String> pair = new ArrayList<String>();
								computePair(k,j+1,pair,newOrdering);
								String otherPoint = newOrdering.get(k);
								
								if(otherPoint.length() > 1){									
									//VP-VP edge
									copyOfEdgeColors.put(pair,"cyan");
								}
								else if(thisPoint.indexOf(otherPoint) == -1){									
									//VP-Guard that don't see each other
									copyOfEdgeColors.put(pair,"orange");				
								}
								else{
									//VP-Guard that see each other
									copyOfEdgeColors.put(pair,"green");
								}
							}
							
							if (isFeasibleOrdering(newOrdering,copyOfEdgeColors,false)){
								updatedGaps.add(currentLeftPoint+":"+currentRightPoint);								
								if(updatedGaps.size() > bigThreshold && !importantPoints.contains(thisPoint)){
									break lookingForGapsLoop;
								}
							}							
						}						
						currentLeftPoint = currentRightPoint;
						j++;						
					}while(!currentRightPoint.equals(oldGapRightPoint));					
					oldGapIndex++;
				}
				
				//We have the list of updated gaps for this point.				
				if(updatedGaps.size() == 0){
					printToOutputFile("No gaps for " + thisPoint + ".  Rejecting.");
					for(int z=0; z<usableViewpoints.size(); z++){
						String prevPoint = usableViewpoints.get(z);
						String hashKey = prevPoint;
						Stack<ArrayList<String>> theStack = gapsThatWork.get(hashKey);					
						if(theStack.size() > startingStackSize)
						theStack.pop();
					}					
					return null;  //null means we are rejecting.
				}
				
				if(updatedGaps.size() == 1){					
					if(foundTrivialGapForThisPoint){					
						//Point became trivial after adding a point with only 1 gap.  If we pushed something onto its stack, we need to remove it now because we aren't going to remove it later.
						if(stackForThisPoint.size() > startingStackSize){
							gapsThatWorkedBefore = stackForThisPoint.pop();
						}
					}
					else{
						printToOutputFile(thisPoint + " has only one gap.  Adding it.");						
						addedPointToOrder = true;
						String theGapString = updatedGaps.get(0);
						String rightEndOfGap = theGapString.substring(theGapString.indexOf(':')+1);
						int theGap = 0;
						while(!rightEndOfGap.equals(ordering.get(theGap))){
							theGap++;
						}
						ordering.add(theGap, thisPoint);
						
						HashMap<ArrayList<String>, String> copyOfEdgeColors = new HashMap<ArrayList<String>, String>(edgeColor);
						
						for(int k=0; k<ordering.size(); k++){
							if(k==theGap)
							continue;
							
							ArrayList<String> pair = new ArrayList<String>();
							computePair(k,theGap,pair,ordering);
							String otherPoint = ordering.get(k);
							
							if(otherPoint.length() > 1){
								//VP-VP edge
								copyOfEdgeColors.put(pair,"cyan");
							}
							else if(thisPoint.indexOf(otherPoint) == -1){								
								//VP-Guard that don't see each other
								copyOfEdgeColors.put(pair,"orange");				
							}
							else{
								//VP-Guard that see each other
								copyOfEdgeColors.put(pair,"green");
							}
						}
						
						isFeasibleOrdering(ordering,copyOfEdgeColors,true);
						edgeColor = allTheMaps.get("edgeColor" + ordering.size());
					}
				}
				else if(updatedGaps.size() > bigThreshold && !importantPoints.contains(thisPoint)){
					ArrayList<String> tooMany = new ArrayList<String>();
					tooMany.add("Big");
					tooMany.add("ManyViewpoints");
					gapsThatWork.get(thisPoint).push(tooMany);
				}
				else{
					gapsThatWork.get(thisPoint).push(updatedGaps);
				}				
			}
		}
		return ordering;
	}
	
	public static boolean pointIsTrivial(ArrayList<String> ordering, String thisPoint, HashMap<ArrayList<String>, String> edgeColor){		
		Stack<ArrayList<String>> stackForThisPoint = gapsThatWork.get(thisPoint);		
		if(stackForThisPoint == null){ 
			return false;
		}
		
		ArrayList<String> gapsThatWorkedBefore = stackForThisPoint.peek();		
		int j = -1;
		int oldGapIndex = 0;
		String currentLeftPoint = "-infty";
		
		while(j<ordering.size()-1 && oldGapIndex < gapsThatWorkedBefore.size()){			
			String oldGap = gapsThatWorkedBefore.get(oldGapIndex);
			String oldGapLeftPoint = oldGap.substring(0,oldGap.indexOf(':'));
			String oldGapRightPoint = oldGap.substring(oldGap.indexOf(':')+1);
			
			while(!currentLeftPoint.equals(oldGapLeftPoint)){
				j++;
				currentLeftPoint = ordering.get(j);
			}
			
			String currentRightPoint;
			do{
				currentRightPoint = ordering.get(j+1);
				if(gapIsTrivialToLeft(currentLeftPoint, thisPoint, ordering, j, edgeColor) || gapIsTrivialToRight(thisPoint, currentRightPoint, ordering, j+1, edgeColor)){					
					return true;
				}				
				currentLeftPoint = currentRightPoint;
				j++;
				
			}while(!currentRightPoint.equals(oldGapRightPoint));
			oldGapIndex++;
		}
		return false;
	}
	
	public static boolean gapIsTrivialToLeft(String currentLeftPoint, String thisPoint, ArrayList<String> ordering, int indexOfPointInOrder, HashMap<ArrayList<String>, String> edgeColor){		
		//Gap is trivial if thisPoint sees a subset of what currentLeftPoint sees, and the guards it doesn't see 
		//all come before the first guard that it does see.
		if(currentLeftPoint.length() > thisPoint.length() && thisPoint.length() > 1){
			//Gap isn't trivial if currentLeftPoint is a guard or it sees fewer guards than thisPoint.			
			//Does it see a subset of currentLeftPoint?
			int currentChar = 0;
			for(int z=0; z<currentLeftPoint.length(); z++){
				
				if(currentLeftPoint.charAt(z) == thisPoint.charAt(currentChar)){
					currentChar++;
				}
				
				if(currentChar == thisPoint.length()){
					break;
				}
			}
			
			if(currentChar == thisPoint.length()){
				
				int numGuardsToBlock = currentLeftPoint.length() - thisPoint.length();
				int numGuardsBlocked = 0;
				
				//It does see a subset of currentLeftPoint.
				int firstGuardLeftOfCurrentLeft = (indexOfPointInOrder - 1 + ordering.size())%ordering.size();
				while(ordering.get(firstGuardLeftOfCurrentLeft).length() > 1)
				firstGuardLeftOfCurrentLeft = (firstGuardLeftOfCurrentLeft-1 + ordering.size())%ordering.size();
				
				int guardIndex = ordering.get(firstGuardLeftOfCurrentLeft).charAt(0) - 'A';
				char curGuard = (char)('A'+guardIndex);
				
				int indexOfFirstGuardThisPointSeesToRight = (guardIndex+1)%9;
				char rightGuard = (char)('A'+indexOfFirstGuardThisPointSeesToRight);
				while(thisPoint.indexOf(rightGuard) < 0){
					indexOfFirstGuardThisPointSeesToRight = (indexOfFirstGuardThisPointSeesToRight+1)%9;
					rightGuard = (char)('A'+indexOfFirstGuardThisPointSeesToRight);
				}
				//Now rightGuard is first guard seen by thisPoint to the right.
				
				while(thisPoint.indexOf(curGuard) < 0){					
					if(currentLeftPoint.indexOf(curGuard) >= 0){
						numGuardsBlocked++;
					}					
					//Moving forward 8 guards is the same as moving back 1.
					guardIndex = (guardIndex + 8)%9;
					curGuard = (char)('A' + guardIndex);
				}
				
				if(numGuardsBlocked == numGuardsToBlock){
					//leftGuard is first guard thisPoint sees to the left.
					char leftGuard = curGuard;
					
					//Gap is trivial as long as currentLeftPoint isn't blocking leftGuard from rightGuard.
					
					if(leftGuard > rightGuard && leftGuard - rightGuard <= 3){
						return true;
					}
					
					if(rightGuard > leftGuard && rightGuard - leftGuard >= 6){
						return true;
					}
					
					ArrayList<String> pair = new ArrayList<String>();
					String guardOne = "";
					guardOne += leftGuard;
					
					String guardTwo = "";
					guardTwo += rightGuard;
					
					if(leftGuard<rightGuard)
					{
						pair.add(guardOne);
						pair.add(guardTwo);
						if(cannotBlock(edgeColor.get(pair)))
						return true;
					}
					else{						
						pair.add(guardTwo);
						pair.add(guardOne);
						if(cannotBlock(edgeColor.get(pair)))
						return true;
					}					
				}
			}			
		}				
		return false;
	}
	
	public static boolean gapIsTrivialToRight(String thisPoint, String currentRightPoint,  ArrayList<String> ordering, int indexOfPointInOrder, HashMap<ArrayList<String>, String> edgeColor){
		//Same but to the right.
		if(currentRightPoint.length() > thisPoint.length() && thisPoint.length() > 1){
			//Gap isn't trivial if currentRightPoint is a guard or it sees fewer guards than thisPoint.			
			//Does it see a subset of currentRightPoint?
			int currentChar = 0;
			for(int z=0; z<currentRightPoint.length(); z++){				
				if(currentRightPoint.charAt(z) == thisPoint.charAt(currentChar)){
					currentChar++;
				}				
				if(currentChar == thisPoint.length()){
					break;
				}
			}
			
			if(currentChar == thisPoint.length()){				
				int numGuardsToBlock = currentRightPoint.length() - thisPoint.length();
				int numGuardsBlocked = 0;
				
				//It does see a subset of currentRightPoint.
				int firstGuardRightOfCurrentRight = (indexOfPointInOrder + 1)%ordering.size();
				while(ordering.get(firstGuardRightOfCurrentRight).length() > 1)
				firstGuardRightOfCurrentRight = (firstGuardRightOfCurrentRight+1)%ordering.size();
				
				int guardIndex = ordering.get(firstGuardRightOfCurrentRight).charAt(0) - 'A';
				char curGuard = (char)('A'+guardIndex);
				
				int indexOfFirstGuardThisPointSeesToLeft = (guardIndex+8)%9;
				char leftGuard = (char)('A'+indexOfFirstGuardThisPointSeesToLeft);
				while(thisPoint.indexOf(leftGuard) < 0){
					indexOfFirstGuardThisPointSeesToLeft = (indexOfFirstGuardThisPointSeesToLeft+8)%9;
					leftGuard = (char)('A'+indexOfFirstGuardThisPointSeesToLeft);
				}
				//Now leftGuard is first guard seen by thisPoint to the left.
				
				while(thisPoint.indexOf(curGuard) < 0){
					
					if(currentRightPoint.indexOf(curGuard) >= 0){
						numGuardsBlocked++;
					}					
					guardIndex = (guardIndex + 1)%9;
					curGuard = (char)('A' + guardIndex);
				}
				
				if(numGuardsBlocked == numGuardsToBlock){
					//rightGuard is first guard thisPoint sees to the right.
					char rightGuard = curGuard;
					
					//Gap is trivial as long as currentLeftPoint isn't blocking leftGuard from rightGuard.					
					if(leftGuard > rightGuard && leftGuard - rightGuard <= 3){
						return true;
					}
					
					if(rightGuard > leftGuard && rightGuard - leftGuard >= 6){
						return true;
					}
					
					ArrayList<String> pair = new ArrayList<String>();
					String guardOne = "";
					guardOne += leftGuard;
					
					String guardTwo = "";
					guardTwo += rightGuard;
					
					if(leftGuard<rightGuard){
						pair.add(guardOne);
						pair.add(guardTwo);
						if(cannotBlock(edgeColor.get(pair)))
						return true;
					}
					else{						
						pair.add(guardTwo);
						pair.add(guardOne);
						if(cannotBlock(edgeColor.get(pair)))
						return true;
					}
				}				
			}			
		}		
		return false;
	}
	
	public static void removeOldGaps(ArrayList<String> usableFromAllPoints){
		for(String thisPoint : usableFromAllPoints){
			gapsThatWork.get(thisPoint).pop();
		}
	}
	
	public static String determineCase(ArrayList<String> ordering){				
		printToOutputFile("Placed " + ordering.size() + " points: " + ordering);		
		ArrayList<String> everyViewpoints = new ArrayList<String>();
		for (String s : allViewpointsConsideredForCurrentCase){
			everyViewpoints.add(s);
		}
		
		HashMap<ArrayList<String>, String> edgeColor = null;
		try{   			
			String key = "edgeColor" + ordering.size();
			edgeColor = allTheMaps.get(key);
		}          
		catch(Exception e){
			e.printStackTrace();
		}
		
		if(ordering.size() > 19 && checkIfPointWithNoGaps(ordering, edgeColor)){
			//If there is a VP in the set of all VPs (that we aren't considering for placement) that doesn't have a gap, we can reject.
			//We haven't altered stack of gaps or edgeColors so we can just reject.
			return "";
		}
		
		ArrayList<String> usableViewpoints = availableViewpoints(ordering, everyViewpoints, edgeColor);
		
		if(usableViewpoints.size() == 0){
			return ordering.toString();
		}
		
		ArrayList<String> importantPoints = new ArrayList<String>();		
		
		int currentOrderingSize = ordering.size();
		ordering = updateGapsForAllPoints(ordering, usableViewpoints, edgeColor, importantPoints);
		if(ordering == null){
			String key = "edgeColor" + currentOrderingSize;
			while(allTheMaps.containsKey(key)){
				allTheMaps.remove(key);
				currentOrderingSize++;
				key = "edgeColor" + currentOrderingSize;
			}
			return "";
		}
		
		int newOrderingSize = ordering.size();
		
		if(currentOrderingSize != newOrderingSize){			
			edgeColor = allTheMaps.get("edgeColor" + newOrderingSize);
			usableViewpoints = availableViewpoints(ordering, everyViewpoints,edgeColor);
			
			if(usableViewpoints.size() == 0){				
				for(int sizeToRemove = currentOrderingSize; sizeToRemove <= newOrderingSize; sizeToRemove++){
					String key = "edgeColor" + sizeToRemove;
					allTheMaps.remove(key);
				}
				return ordering.toString();
			}
		}
		
		//Determine which viewpoint is the point we are going to recurse.
		int minIndex = 0;
		ArrayList<String> gaps = gapsThatWork.get(usableViewpoints.get(0)).peek();
		int min = 999;
		if(gaps.get(0).equals("Big")){
			min = 999;
		}else{
			min = gaps.size();
		}
		
		for(int i = 1; i<usableViewpoints.size(); i++){			
			gaps = gapsThatWork.get(usableViewpoints.get(i)).peek();
			int len = 999;
			if(gaps.get(0).equals("Big")){
				len = 999;
			}else{
				len = gaps.size();
			}
			
			if(len < min){
				min = len;
				minIndex = i;
			}
		}		
		
		for (int i = 0; i < 1; i++){
			//Insert usableViewpoints[i] into our current ordering in every gap.
			String thisPoint = usableViewpoints.get(minIndex);
			ArrayList<String> gapsForThisPoint = gapsThatWork.get(thisPoint).peek();
			int j = 0;
			for (int z = 0; z < gapsForThisPoint.size(); z++){
				String thisGap = gapsForThisPoint.get(z);
				String rightPointOfGap = thisGap.substring(thisGap.indexOf(':')+1);
				printToOutputFile("Inserting " + thisPoint + " into gap " + thisGap + " (" + (z+1) + " of " + gapsForThisPoint.size() + ")");
				while(!rightPointOfGap.equals(ordering.get(j))){
					j++;
				}
				
				HashMap<ArrayList<String>, String> copyOfEdgeColors = new HashMap<ArrayList<String>, String>(edgeColor);				
				ArrayList<String> newOrdering = new ArrayList<String>();
				newOrdering.clear();
				newOrdering.addAll(ordering);
				newOrdering.add(j, thisPoint);
				
				for(int k = 0; k<newOrdering.size(); k++){
					if(k==j){
						continue;
					}
					
					ArrayList<String> pair = new ArrayList<String>();
					computePair(k,j,pair,newOrdering);
					String otherPoint = newOrdering.get(k);
					
					if(otherPoint.length() > 1){							
						//VP-VP edge
						copyOfEdgeColors.put(pair,"cyan");
					}
					else if(thisPoint.indexOf(otherPoint) == -1){
						
						//VP-Guard that don't see each other
						copyOfEdgeColors.put(pair,"orange");				
					}
					else{
						//VP-Guard that see each other
						copyOfEdgeColors.put(pair,"green");
					}
				}
				
				if (isFeasibleOrdering(newOrdering,copyOfEdgeColors,true)){
					String result = determineCase(newOrdering);
					if (!result.equals("")){
						for(int sizeToRemove = currentOrderingSize; sizeToRemove <= newOrderingSize; sizeToRemove++){
							String key = "edgeColor" + sizeToRemove;
							allTheMaps.remove(key);
						}
						removeOldGaps(usableViewpoints);
						return result;
					}
				}
				else{
					//This will not happen, debugging check only.
					printToOutputFile("Gap that we thought would work came back false.");
				}
			}
		}
		
		for(int sizeToRemove = currentOrderingSize; sizeToRemove <= newOrderingSize; sizeToRemove++){
			String key = "edgeColor" + sizeToRemove;
			allTheMaps.remove(key);
		}
		removeOldGaps(usableViewpoints);
		return "";
	}
	
	//Helper function, return the available viewpoints you could still use.
	public static ArrayList<String> availableViewpoints(ArrayList<String> usedPoints, ArrayList<String> candidatePoints, HashMap<ArrayList<String>,String> edgeColor){
		ArrayList<String> feasibleViewpoints = new ArrayList<String>();
		feasibleViewpoints.addAll(candidatePoints);
		feasibleViewpoints.removeAll(usedPoints);
		
		for(int i = 0; i<feasibleViewpoints.size(); i++){
			if(pointIsTrivial(usedPoints, feasibleViewpoints.get(i), edgeColor)){
				feasibleViewpoints.remove(i);
				i--;
			}
		}
		return feasibleViewpoints;
	}
	
	public static void computePair(int i, int j, ArrayList<String> pair, ArrayList<String> points){
		pair.clear();
		if(i < j){
			pair.add(points.get(i));
			pair.add(points.get(j));
		}
		else{
			pair.add(points.get(j));
			pair.add(points.get(i));
		}
	}
	
	public static void computeGuardPair(int i, int j, ArrayList<String> pair){
		pair.clear();
		String[] guards = {"A","B","C","D","E","F","G","H","I"};
		if(i<j){
			pair.add(guards[i]);
			pair.add(guards[j]);
		}
		else{
			pair.add(guards[j]);
			pair.add(guards[i]);
		}
	}
	
	public static boolean isFeasibleOrdering(ArrayList<String> points, HashMap<ArrayList<String>, String> edgeColor, boolean writeEdgeColor) {
		// Edge colors:
		// Green - See each other - unpierceable and close
		// Red - Do not see other - close - must be pierced
		// Purple - Do not see each other - cannot be pierced - too far
		// Orange - Do not see each other - don't care how we block.
		// Blue - Don't care if see each other - cannot be pierced.
		// Cyan - Don't care if see each other - don't care if pierced.
		// Yellow - Don't care if they see each other - cannot be too far away.
		
		//-10 means they cannot be blocked
		//-1 means they can be blocked but no specific blocker.
		//>=0 means they can only be blocked by the point with the given index.
		
		if(edgeColor == null){
			edgeColor = new HashMap<ArrayList<String>, String>();
			// For every pair of points (u,v):
			// -If u is a guard and v is a viewpoint (or vice versa):
			// - If u sees v, set edgeColor(u,v) = green.
			// - Else set edgeColor(u,v) = orange.
			// -If u and v are both viewpoints or are both guards
			// - Initialize edgeColor(u,v) = cyan.
			for (int i = 0; i < points.size() - 1; i++) {
				for (int j = i + 1; j < points.size(); j++) {
					ArrayList<String> temp = new ArrayList<String>();
					temp.clear();
					temp.add(points.get(i));
					temp.add(points.get(j));
					
					if (points.get(i).length() == 1) {
						if (points.get(j).length() == 1) {
							edgeColor.put(temp, "cyan");//Enforcing that guards see each other.
						} else {
							if (points.get(j).indexOf(points.get(i)) == -1) {
								edgeColor.put(temp, "orange");
							} else {
								edgeColor.put(temp, "green");
							}
						}
					} else {
						if (points.get(j).length() > 1) {
							edgeColor.put(temp, "cyan");
						} else {
							if (points.get(i).indexOf(points.get(j)) == -1) {
								edgeColor.put(temp, "orange");
							} else {
								edgeColor.put(temp, "green");
							}
						}
					}
				}
			}
			
			//Example case that is currently being tested.
			ArrayList<String> hardCode = new ArrayList<String>();			
			
			//One gap edges			
			hardCode.clear();
			hardCode.add("A");
			hardCode.add("B");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("B");
			hardCode.add("C");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("C");
			hardCode.add("D");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("D");
			hardCode.add("E");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("E");
			hardCode.add("F");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("F");
			hardCode.add("G");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("G");
			hardCode.add("H");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("H");
			hardCode.add("I");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("A");
			hardCode.add("I");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("A");
			hardCode.add("D");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("B");
			hardCode.add("E");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("C");
			hardCode.add("F");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("D");
			hardCode.add("G");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("E");
			hardCode.add("H");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("F");
			hardCode.add("I");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("A");
			hardCode.add("G");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("B");
			hardCode.add("H");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("C");
			hardCode.add("I");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("A");
			hardCode.add("C");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("B");
			hardCode.add("D");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("C");
			hardCode.add("E");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("D");
			hardCode.add("F");
			edgeColor.replace(hardCode,"pink");
			
			hardCode.clear();
			hardCode.add("E");
			hardCode.add("G");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("F");
			hardCode.add("H");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("G");
			hardCode.add("I");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("A");
			hardCode.add("H");
			edgeColor.replace(hardCode,"blue");
			
			hardCode.clear();
			hardCode.add("B");
			hardCode.add("I");
			edgeColor.replace(hardCode,"blue");			
		}
		
		boolean updatedAnEdge = false;
		
		//Begin encircling.
		do {						
			ArrayList<String> pair = new ArrayList<String>();
			updatedAnEdge = false;
			for (int i = 0; i < points.size() - 3; i++) {
				int stoppingIndexForL = points.size();
				if(i==0){
					stoppingIndexForL = points.size()-1;
				}
				
				for (int l = i + 2; l != stoppingIndexForL; l++) {
					computePair(i, l, pair, points);
					String ilColor = edgeColor.get(pair);
					
					if(cannotBlock(ilColor)){
						//No reason to search if we already know il cannot be blocked.
						continue;
					}
					
					boolean canBlockAbove, canBlockBelow;
					canBlockAbove = canBlockBelow = true;
					
					int j = i;
					String jlColor = "";
					do{
						j++;
						if(j<l){
							computePair(j, l, pair, points);
							jlColor = edgeColor.get(pair);
						}
					}while(j<l && !cannotBlock(jlColor));
					
					
					int k=l;
					String ikColor="";
					do{
						k--;
						if(k>=j){
							computePair(i, k, pair, points);
							ikColor = edgeColor.get(pair);
						}
						
					}while(k >= j && !cannotBlock(ikColor));
					
					if(k>j){
						canBlockBelow = false;
					}
					else{
						continue;
					}
					
					int m = l;
					String imColor = "";
					do{
						m = (m+1)%points.size();
						if(m!=i){
							computePair(i, m, pair, points);
							imColor = edgeColor.get(pair);
						}
					}while(m!=i && !cannotBlock(imColor));
					
					int n = i;
					int stoppingIndexForN = m-1;
					if(m==0){ 
						stoppingIndexForN = points.size()-1;
					}
					
					String lnColor="";
					do{
						n--;
						if(n < 0) n = points.size()-1;
						if(n!=stoppingIndexForN){
							computePair(n, l, pair, points);
							lnColor = edgeColor.get(pair);
						}
						
					}while(n!=stoppingIndexForN && !cannotBlock(lnColor));					
					
					if(n!=m && n != stoppingIndexForN){
						canBlockAbove = false;
					}
					
					if(!canBlockAbove && !canBlockBelow){
						//Last time we could block on one side, but now we cannot block on either side.						
						pair.clear();
						computePair(i, l, pair, points);
						if(mustBlock(ilColor)){
							return false;
						}
						else{							
							updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
						}
					}
				}
			}//End Encircling.
			
			//Begin crossing lemma.
			for (int i = 0; i < points.size(); i++) {
				for (int k = i + 2; k < points.size(); k++) {
					computePair(i, k, pair, points);
					String ikColor = edgeColor.get(pair);
					
					if (!ikColor.equalsIgnoreCase("green")) {
						continue;
					}					
					
					for (int j = i + 1; j < k; j++) {
						for (int l = (k + 1)%points.size(); l != i; l = (l+1)%points.size()) {
							computePair(j, l, pair, points);
							String jlColor = edgeColor.get(pair);
							
							computePair(i, j, pair, points);
							String ijColor = edgeColor.get(pair);
							
							computePair(j, k, pair, points);
							String jkColor = edgeColor.get(pair);
							
							computePair(i, l, pair, points);
							String ilColor = edgeColor.get(pair);
							
							computePair(k, l, pair, points);
							String klColor = edgeColor.get(pair);
							
							if(jlColor.equalsIgnoreCase("green") && ((mustBeFar(ilColor) && mustBeFar(jkColor)) || (mustBeFar(ijColor) && mustBeFar(klColor)))){
								return false;
							}
							
							if(jlColor.equalsIgnoreCase("green")){								
								if(mustBeFar(ijColor)){									
									computePair(k, l, pair, points);
									updatedAnEdge = makeEdgeClose(edgeColor,pair) || updatedAnEdge;
								}								
								if(mustBeFar(jkColor)){									
									computePair(i, l, pair, points);
									updatedAnEdge = makeEdgeClose(edgeColor,pair) || updatedAnEdge;
								}								
								if(mustBeFar(klColor)){									
									computePair(i, j, pair, points);
									updatedAnEdge = makeEdgeClose(edgeColor,pair) || updatedAnEdge;
								}								
								if(mustBeFar(ilColor)){									
									computePair(j, k, pair, points);
									updatedAnEdge = makeEdgeClose(edgeColor,pair) || updatedAnEdge;
								}								
							}
							else{								
								if((mustBeFar(ilColor) && mustBeFar(jkColor)) || (mustBeFar(ijColor) && mustBeFar(klColor))){									
									computePair(j, l, pair, points);
									updatedAnEdge = makeEdgeNotVisible(edgeColor,pair) || updatedAnEdge;									
								}								
							}							
						}
					}
				}
			}//End crossing lemma.
			
			//Begin purple green crossing.
			for(int i = 0; i<points.size(); i++){				
				purpleGreenJ:
				for(int j = (i+1)%points.size(); j != i; j = (j+1)%points.size()){					
					boolean haveANonLemmaEdgeAfterJ = false;
					int pointToFlip1AfterJ = -1;
					int pointToFlip2AfterJ = -1;
					int edgeChangeTypeAfterJ = -1;
					
					computePair(i, j, pair, points);
					String ijColor = edgeColor.get(pair);
					
					if(!mustBeFar(ijColor)){						
						if(mustBeClose(ijColor)){
							continue;
						}						
						haveANonLemmaEdgeAfterJ = true;
						pointToFlip1AfterJ = i;
						pointToFlip2AfterJ = j;
						edgeChangeTypeAfterJ = 0;
					}
					
					purpleGreenSeesI:
					for(int seesI = (j+1)%points.size(); seesI != i; seesI = (seesI + 1)%points.size()){
						
						boolean haveANonLemmaEdgeAfterSeesI = haveANonLemmaEdgeAfterJ;
						int pointToFlip1AfterSeesI = pointToFlip1AfterJ;
						int pointToFlip2AfterSeesI = pointToFlip2AfterJ;
						int edgeChangeTypeAfterSeesI = edgeChangeTypeAfterJ;
						
						computePair(i, seesI, pair, points);
						String seesIColor = edgeColor.get(pair);
						if(!seesIColor.equalsIgnoreCase("green")){							
							if(haveANonLemmaEdgeAfterSeesI || cannotSee(seesIColor)){
								continue;
							}else{								
								haveANonLemmaEdgeAfterSeesI = true;
								pointToFlip1AfterSeesI = i;
								pointToFlip2AfterSeesI = seesI;
								edgeChangeTypeAfterSeesI = 1;
							}
						}
						
						purpleGreenK:
						for(int k = (seesI + 1)%points.size(); k!=i; k = (k+1)%points.size()){							
							boolean haveANonLemmaEdgeAfterK = haveANonLemmaEdgeAfterSeesI;
							int pointToFlip1AfterK = pointToFlip1AfterSeesI;
							int pointToFlip2AfterK = pointToFlip2AfterSeesI;
							int edgeChangeTypeAfterK = edgeChangeTypeAfterSeesI;
							
							computePair(i, k, pair, points);
							String ikColor = edgeColor.get(pair);
							
							if(!ikColor.equalsIgnoreCase("purple")){								
								if(haveANonLemmaEdgeAfterK || mustBeClose(ikColor) || mustBlock(ikColor)){
									continue;
								}else{
									haveANonLemmaEdgeAfterK = true;
									pointToFlip1AfterK = i;
									pointToFlip2AfterK = k;
									edgeChangeTypeAfterK = 2;
								}
							}
							
							computePair(j, k, pair, points);
							String jkColor = edgeColor.get(pair);
							
							if(!cannotBlock(jkColor)){								
								if(haveANonLemmaEdgeAfterK || mustBlock(jkColor)){
									continue;
								}else{
									haveANonLemmaEdgeAfterK = true;
									pointToFlip1AfterK = j;
									pointToFlip2AfterK = k;
									edgeChangeTypeAfterK = 2;
								}
							}
							
							purpleGreenL:
							for(int l = (k+1)%points.size(); l!=i; l = (l+1)%points.size()){								
								boolean haveANonLemmaEdgeAfterL = haveANonLemmaEdgeAfterK;
								int pointToFlip1AfterL = pointToFlip1AfterK;
								int pointToFlip2AfterL = pointToFlip2AfterK;
								int edgeChangeTypeAfterL = edgeChangeTypeAfterK;
								
								computePair(i, l, pair, points);
								String ilColor = edgeColor.get(pair);
								
								if(!mustBeFar(ilColor)){									
									if(haveANonLemmaEdgeAfterL || mustBeClose(ilColor)){
										continue;
									}else{
										haveANonLemmaEdgeAfterL = true;
										pointToFlip1AfterL = i;
										pointToFlip2AfterL = l;
										edgeChangeTypeAfterL = 0;
									}
								}
								
								computePair(j, l, pair, points);
								String jlColor = edgeColor.get(pair);
								
								if(!jlColor.equalsIgnoreCase("green")){									
									if(haveANonLemmaEdgeAfterL || cannotSee(jlColor)){
										continue;
									}else{
										haveANonLemmaEdgeAfterL = true;
										pointToFlip1AfterL = j;
										pointToFlip2AfterL = l;
										edgeChangeTypeAfterL = 1;
									}
								}
								
								computePair(k, l, pair, points);
								String klColor = edgeColor.get(pair);
								
								if(!mustBeFar(klColor)){								
									if(haveANonLemmaEdgeAfterL || mustBeClose(klColor)){
										continue;
									}else{
										haveANonLemmaEdgeAfterL = true;
										pointToFlip1AfterL = k;
										pointToFlip2AfterL = l;
										edgeChangeTypeAfterL = 0;
									}
								}
								
								if(!haveANonLemmaEdgeAfterL){									
									return false;									
								}
								else if(edgeChangeTypeAfterL == 0){									
									//edge must be close.
									computePair(pointToFlip1AfterL, pointToFlip2AfterL, pair, points);
									updatedAnEdge = makeEdgeClose(edgeColor,pair) || updatedAnEdge;
									
								}
								else if(edgeChangeTypeAfterL == 1){									
									//edge must not be visible.
									computePair(pointToFlip1AfterL, pointToFlip2AfterL, pair, points);
									updatedAnEdge = makeEdgeNotVisible(edgeColor,pair) || updatedAnEdge;									
								}
								else if(edgeChangeTypeAfterL == 2){									
									//edge must be blocked.
									computePair(pointToFlip1AfterL, pointToFlip2AfterL, pair, points);
									
									//If ik is the non lemma edge and it cannot be blocked, we can reject.  jk we already know can be blocked if we are here.
									if(cannotBlock(edgeColor.get(pair))){										
										return false;
									}									
									updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;								
								}
								
								//We just flipped the non-lemma edge, so we can continue the loop for the 2nd point of that edge.
								if(pointToFlip2AfterL == j){
									continue purpleGreenJ;
								}
								else if(pointToFlip2AfterL == seesI){
									continue purpleGreenSeesI;
								}
								else if(pointToFlip2AfterL == k){
									continue purpleGreenK;
								}
								else if(pointToFlip2AfterL == l){
									continue purpleGreenL;
								}								
							}
						}												
					}					
				}
			}//End purple green crossing.
			
			//Will call makeEdgeNotVisible()
			for(int i = 0; i<points.size(); i++){				
				jLoop2:
				for(int j = (i+1)%points.size(); j != i; j = (j+1)%points.size()){
					boolean haveANonLemmaEdgeAfterJ = false;
					int pointToFlip1AfterJ = -1;
					int pointToFlip2AfterJ = -1;
					int edgeChangeTypeAfterJ = -1;
					
					computePair(i, j, pair, points);
					String ijColor = edgeColor.get(pair);
					if (!mustBeFar(ijColor)) // i, j is too far
					{
						if (mustBeClose(ijColor)){
							continue;
						}
						else{
							haveANonLemmaEdgeAfterJ = true;
							pointToFlip1AfterJ = i;
							pointToFlip2AfterJ = j;
							edgeChangeTypeAfterJ = 0;
						}
					}
					seesILoop2:
					for(int seesI = (j+1)%points.size(); seesI != i; seesI = (seesI + 1)%points.size()){
						boolean haveANonLemmaEdgeAfterSeesI = haveANonLemmaEdgeAfterJ;
						int pointToFlip1AfterSeesI = pointToFlip1AfterJ;
						int pointToFlip2AfterSeesI = pointToFlip2AfterJ;
						int edgeChangeTypeAfterSeesI = edgeChangeTypeAfterJ;
						
						computePair(i, seesI, pair, points);
						String seesIColor = edgeColor.get(pair);
						if(!seesIColor.equalsIgnoreCase("green")){ 
							// i sees "seesI"
							if(haveANonLemmaEdgeAfterSeesI || mustBeFar(seesIColor) || mustBlock(seesIColor)){
								continue;
							}
							else{
								haveANonLemmaEdgeAfterSeesI = true;
								pointToFlip1AfterSeesI = i;
								pointToFlip2AfterSeesI = seesI;
								edgeChangeTypeAfterSeesI = 1;
							}
							
							kLoop2:
							for(int k = (seesI + 1)%points.size(); k!=i; k = (k+1)%points.size()){ // jk cannot be blocked
								boolean haveANonLemmaEdgeAfterK = haveANonLemmaEdgeAfterSeesI;
								int pointToFlip1AfterK = pointToFlip1AfterSeesI;
								int pointToFlip2AfterK = pointToFlip2AfterSeesI;
								int edgeChangeTypeAfterK = edgeChangeTypeAfterSeesI;
								computePair(j, k, pair, points);
								String jkColor = edgeColor.get(pair);
								if (!cannotBlock(jkColor)){ 
									if(haveANonLemmaEdgeAfterK || mustBlock(jkColor)){
										continue;
									}
									else{
										haveANonLemmaEdgeAfterK = true;
										pointToFlip1AfterK = j;
										pointToFlip2AfterK = k;
										edgeChangeTypeAfterK = 2;
									}
									lLoop2:
									for(int l = (k+1)%points.size(); l!=i; l = (l+1)%points.size()){ // il cannot be blocked
										boolean haveANonLemmaEdgeAfterL = haveANonLemmaEdgeAfterK;
										int pointToFlip1AfterL = pointToFlip1AfterK;
										int pointToFlip2AfterL = pointToFlip2AfterK;
										int edgeChangeTypeAfterL = edgeChangeTypeAfterK;
										computePair(i, l, pair, points);
										String ilColor = edgeColor.get(pair);
										if (!cannotBlock(ilColor)){
											if(haveANonLemmaEdgeAfterK || mustBlock(ilColor)){
												continue;
											}
											else{
												haveANonLemmaEdgeAfterL = true;
												pointToFlip1AfterL = i;
												pointToFlip2AfterL = l;
												edgeChangeTypeAfterL = 2;
											}
											
											computePair(j, l, pair, points); // j sees l
											String jlColor = edgeColor.get(pair);
											if(!jlColor.equalsIgnoreCase("green")){
												if(haveANonLemmaEdgeAfterL || mustBeFar(jlColor) || mustBlock(jlColor)){
													continue;
												}
												else{
													haveANonLemmaEdgeAfterL = true;
													pointToFlip1AfterL = j;
													pointToFlip2AfterL = l;
													edgeChangeTypeAfterL = 1;
												}
												computePair(k, l, pair, points);
												String klColor = edgeColor.get(pair);
												if(!mustBeFar(klColor)){ // kl is too far
													if(haveANonLemmaEdgeAfterL || mustBeClose(klColor)){
														continue;
													} else {
														haveANonLemmaEdgeAfterL = true;
														pointToFlip1AfterL = k;
														pointToFlip2AfterL = l;
														edgeChangeTypeAfterL = 0;
													}
													
													for (int r = (l+1)%points.size(); r != i; r = (r+1)%points.size()){ // k cannot see any point between (l, i)
														computePair(k, r, pair, points);
														String krColor = edgeColor.get(pair);
														if(krColor.equalsIgnoreCase("green"))
														{
															if (!haveANonLemmaEdgeAfterL)
															{
																return false;
															}
															else if (edgeChangeTypeAfterL == 0)
															{
																computePair(pointToFlip1AfterL,pointToFlip2AfterL,pair,points);
																updatedAnEdge = makeEdgeClose(edgeColor,pair) || updatedAnEdge;
																
																if(pointToFlip2AfterL == j){
																	continue jLoop2;
																}
																else{
																	continue lLoop2;															
																}
															}
															else if (edgeChangeTypeAfterL == 1)
															{
																computePair(pointToFlip1AfterL,pointToFlip2AfterL,pair,points);
																updatedAnEdge = makeEdgeNotVisible(edgeColor,pair) || updatedAnEdge;
																
																if(pointToFlip2AfterL == seesI){
																	continue seesILoop2;
																}
																else{
																	continue lLoop2;
																}
															}
															else if (edgeChangeTypeAfterL == 2)
															{
																computePair(pointToFlip1AfterL,pointToFlip2AfterL,pair,points);
																updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
																
																if(pointToFlip2AfterL == k){
																	continue kLoop2;
																}
																else{
																	continue lLoop2;
																}
															}
														}
														else if(!haveANonLemmaEdgeAfterL){														
															updatedAnEdge = makeEdgeNotVisible(edgeColor,pair) || updatedAnEdge;
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}			
			//Check for double triangle edge blockers.
			int triangleEdgeBlocker = checkTriangleEdgeBlockers(points,edgeColor);
			if(triangleEdgeBlocker == 0)
			{
				return false;
			}
			else if(triangleEdgeBlocker == 1){			
				updatedAnEdge = true;
			}
			
			//Check for threeFour edge blockers.
			int threeFourEdgeBlocker = checkThreeFourEdgeBlockers(points,edgeColor);
			if(threeFourEdgeBlocker == 0){
				return false;
			}
			else if(threeFourEdgeBlocker == 1){			
				updatedAnEdge = true;
			}
			
			//Case Rejection.
			int forbiddenSubgraph = checkForbiddenSubgraphs(edgeColor);
			if(forbiddenSubgraph == 0){
				return false;
			}
			else if(forbiddenSubgraph == 1){			
				updatedAnEdge = true;
			}
			
			//Begin find a blocker.
			for(int i = 0; i<points.size(); i++){			
				for(int j = i+1; j<points.size(); j++){					
					computePair(i, j, pair, points);
					String ijColor = edgeColor.get(pair);
					if(!mustBlock(ijColor)){
						continue;
					}
					
					int z;
					for(z = j-1; z>i; z--){
						computePair(i, z, pair, points);
						String izColor = edgeColor.get(pair);
						if(cannotBlock(izColor)){						
							break;
						}
					}
					
					int y;
					for(y = i+1; y<j; y++){
						computePair(y, j, pair, points);
						String yjColor = edgeColor.get(pair);				
						if(cannotBlock(yjColor)){						
							break;
						}
					}
					
					boolean canBlockCCW = (z <= y);				
					if(z < y)
					{
						//If a point in (i,z) is blue to a point in (y,j), then cannot block.
						blueCheckCCW:
						for(int p1 = i+1; p1 < z; p1++){						
							for(int p2 = y+1; p2 < j; p2++){							
								computePair(p1, p2, pair, points);
								if(cannotBlock(edgeColor.get(pair))){								
									canBlockCCW = false;
									break blueCheckCCW;
								}
							}
						}
					}
					
					//A guard cannot block two other guards.
					if(canBlockCCW && z==y && points.get(i).length() == 1 && points.get(j).length() == 1 && points.get(z).length() == 1){
						canBlockCCW = false;  
					}				
					
					if(canBlockCCW && points.get(i).length() == 1 && points.get(j).length() == 1){					
						char c1 = points.get(i).charAt(0);
						char c2 = points.get(j).charAt(0);					
						if(c2-c1 >= 6){						
							canBlockCCW = false;
						}
						
					}
					
					//Check CW side.
					int a = i-1;
					if(a<0){ 
						a = points.size()-1;
					}
					while(a!=j){
						computePair(a, j, pair, points);
						String ajColor = edgeColor.get(pair);
						if(cannotBlock(ajColor)){						
							break;
						}					
						a--;
						if(a<0){
							a = points.size()-1;
						}
					}
					
					int b = j+1;
					if(b==points.size()){
						b = 0;
					}
					while(b!=i){
						computePair(b, i, pair, points);
						String biColor = edgeColor.get(pair);
						if(cannotBlock(biColor)){						
							break;
						}					
						b++;
						if(b==points.size()){
							b = 0;
						}
					}
					
					
					boolean canBlockCW;
					if(a >= j){
						//a wrapped around past 0.
						if(b <= i || b >= a){
							canBlockCW = true;
						}else{
							canBlockCW = false;
						}
					}
					else{
						if(b >= a && b <= i){
							canBlockCW = true;
						}
						else{
							canBlockCW = false;
						}
					}
					
					if(canBlockCW && a != b && b != i && a != j){
						//If a point in (j,a) is blue to a point in (b,i), then cannot block.
						blueCheckCW:
						for(int p1 = (j+1)%points.size(); p1 != a; p1 = (p1+1)%points.size()){						
							for(int p2 = (b+1)%points.size(); p2 != i; p2 = (p2+1)%points.size()){							
								computePair(p1, p2, pair, points);
								String thisColor = edgeColor.get(pair);
								if(cannotBlock(thisColor)){								
									canBlockCW = false;
									break blueCheckCW;
								}
							}
						}
					}
					
					if(canBlockCW && a==b && points.get(i).length() == 1 && points.get(j).length() == 1 && points.get(a).length() == 1){
						canBlockCW = false;  
					}				
					
					if(canBlockCW && points.get(i).length() == 1 && points.get(j).length() == 1){					
						char c1 = points.get(i).charAt(0);
						char c2 = points.get(j).charAt(0);					
						if(c2-c1 <= 3){						
							canBlockCW = false;
						}					
					}				
					
					if(!canBlockCCW && !canBlockCW){
						return false;					
					}
					
					if(canBlockCCW && canBlockCW){
						continue;
					}
					
					if(canBlockCCW){					
						ArrayList<Integer> blockers = new ArrayList<Integer>();
						if(z == y){
							blockers.add(z);
						}
						else{						
							computePair(z,y,pair,points);
							if(cannotBlock(edgeColor.get(pair))){							
								//At least one of {z,y} has to be over i,j line.
								computePair(z,j,pair,points);
								String zjColor = edgeColor.get(pair);
								if(mustBlock(zjColor)){								
									//if z,j must be blocked, then y has to be above i,j line.
									blockers.add(y);
								}
								
								computePair(i,y,pair,points);
								String iyColor = edgeColor.get(pair);
								if(mustBlock(iyColor)){						
									//if i,y must be blocked, then z has to be above i,j line.
									blockers.add(z);
								}						
								//If both could be below the line at this point (i.e., blockers is empty here), then we could check to see if there is an x that would cause a rejection if we put the y or z above the line.  This would force the other one to be above the line.
							}
						}
						
						for(int blockerIndex = 0; blockerIndex < blockers.size(); blockerIndex++){						
							z = blockers.get(blockerIndex);						
							//If a guard is the blocker for two other guards, you cannot place a VP that sees i and j and does not see z.
							if(points.get(i).length() == 1 && points.get(j).length() == 1 && points.get(z).length() == 1){
								return false;
							}
							
							computePair(i, z, pair, points);						
							computePair(z, j, pair, points);
							
							for(int firstPoint = i; firstPoint < z; firstPoint++){							
								for(int secondPoint = z+1; secondPoint <= j; secondPoint++){								
									computePair(firstPoint, secondPoint, pair, points);								
									String theirColor = edgeColor.get(pair);
									if(cannotBlock(theirColor)){									
										return false;
									}
									else{									
										updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
									}								
								}
							}
							
							//For all points x on CW side s.t. (i,x) and (j,x) are green, red, or yellow (not too far away), then (z,x) cannot be too far away.
							//For all points x on CW side s.t. (z,x) is purple, x must be purple to at least one of i and j.						
							for(int x = (j+1)%points.size(); x != i; x = (x+1)%points.size()){							
								computePair(x, z, pair, points);
								String zxColor = edgeColor.get(pair);							
								if(zxColor.equalsIgnoreCase("green")){								
									continue;
								}							
								boolean xSeesPointBetweenIandZ = false;
								for(int w = i; w < z; w++){								
									computePair(x, w, pair, points);
									if(edgeColor.get(pair).equalsIgnoreCase("green")){
										xSeesPointBetweenIandZ = true;
										break;
									}
								}							
								
								boolean xSeesPointBetweenZandJ = false;
								for(int w = z+1; w <= j; w++){								
									computePair(x, w, pair, points);
									if(edgeColor.get(pair).equalsIgnoreCase("green")){
										xSeesPointBetweenZandJ = true;
										break;
									}
								}							
								
								if(xSeesPointBetweenIandZ && xSeesPointBetweenZandJ){								
									if(cannotSee(zxColor)){									
										return false;
									}
									else{									
										computePair(x, z, pair, points);
										edgeColor.replace(pair,"green");
										updatedAnEdge = true;
										continue;
									}
								}
								else if(xSeesPointBetweenIandZ){								
									if(mustBlock(zxColor)){									
										for(int w = z+1; w<= j; w++){										
											computePair(x, w, pair, points);
											String xwColor = edgeColor.get(pair);
											if(cannotBlock(xwColor)){											
												return false;
											}
											else{											
												updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
											}
										}
									}
									else if(mustBeFar(zxColor)){									
										boolean foundCloseXBlueZ = false;
										for(int w = j; w > z; w--){										
											computePair(x, w, pair, points);
											String xwColor = edgeColor.get(pair);
											
											if(!foundCloseXBlueZ && mustBeClose(xwColor)){											
												computePair(z, w, pair, points);
												String zwColor = edgeColor.get(pair);											
												if(cannotBlock(zwColor)){
													foundCloseXBlueZ = true;
												}
												
											}
											
											if(xwColor.equalsIgnoreCase("green")){											
												return false;
											}
											else{											
												if(!foundCloseXBlueZ){
													updatedAnEdge = makeEdgeNotVisible(edgeColor,pair) || updatedAnEdge;
												}
												else{												
													for(int pointToBlock = x; pointToBlock != z; pointToBlock = (pointToBlock+1)%points.size()){													
														computePair(pointToBlock, w, pair, points);
														String ptbwColor = edgeColor.get(pair);
														if(cannotBlock(ptbwColor)){
															return false;
														}
														else{
															updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
														}													
													}
												}
											}
										}									
									}
								}
								else if(xSeesPointBetweenZandJ){								
									if(mustBlock(zxColor)){									
										for(int w = i; w< z; w++){										
											computePair(x, w, pair, points);
											String xwColor = edgeColor.get(pair);
											if(cannotBlock(xwColor)){											
												return false;
											}
											else{											
												updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
											}
										}
									}
									else if(mustBeFar(zxColor)){																		
										boolean foundCloseXBlueZ = false;
										for(int w = i; w < z; w++){										
											computePair(x, w, pair, points);
											String xwColor = edgeColor.get(pair);										
											if(!foundCloseXBlueZ && mustBeClose(xwColor)){											
												computePair(z, w, pair, points);
												String zwColor = edgeColor.get(pair);										
												if(cannotBlock(zwColor)){
													foundCloseXBlueZ = true;											
												}
											}										
											if(xwColor.equalsIgnoreCase("green")){											
												return false;
											}
											else{											
												if(!foundCloseXBlueZ){
													updatedAnEdge = makeEdgeNotVisible(edgeColor,pair) || updatedAnEdge;
												}
												else{												
													int pointToStop = (x+1)%points.size();
													for(int pointToBlock = z+1; pointToBlock != pointToStop; pointToBlock = (pointToBlock+1)%points.size()){													
														computePair(pointToBlock, w, pair, points);
														String ptbwColor = edgeColor.get(pair);
														if(cannotBlock(ptbwColor)){
															return false;
														}
														else{
															updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
														}													
													}
												}
											}
										}									
									}
								}
							}
						}
						
						if(blockers.size() == 0){						
							//Every point x \in [i,z) must be red to every point w \in (y,j].
							//If i wasn't blue to anything, then z==i. It still can be blocked from points in (y,j].
							for(int x = i; x==i || x<z; x++){							
								for(int w = j; w == j || w > y; w--){								
									computePair(w, x, pair, points);
									String theirColor = edgeColor.get(pair);								
									if(cannotBlock(theirColor)){									
										return false;
									}
									else{									
										updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;								
									}
								}
							}					
						}					
					}
					else{				
						//Blocking on CW side					
						ArrayList<Integer> blockers = new ArrayList<Integer>();
						if(a == b){
							blockers.add(a);
						}
						else{						
							computePair(a,b,pair,points);
							if(cannotBlock(edgeColor.get(pair))){							
								//At least one of {a,b} has to be below i,j line.
								computePair(b,j,pair,points);
								if(mustBlock(edgeColor.get(pair))){								
									//if b,j must be blocked, then a has to be below i,j line.
									blockers.add(a);
								}
								
								computePair(i,a,pair,points);
								if(mustBlock(edgeColor.get(pair))){								
									//if i,a must be blocked, then b has to be below i,j line.
									blockers.add(b);
								}							
								//If both could be above the line at this point (i.e., blockers is empty here), then we could check to see if there is an x that would cause a rejection if we put the a or b below the line.  This would force the other one to be below the line.
							}
						}
						
						for(int blockerIndex = 0; blockerIndex < blockers.size(); blockerIndex++){						
							a = blockers.get(blockerIndex);						
							//If a guard is the blocker for two other guards, you cannot place a VP that sees i and j and does not see a.
							if(points.get(i).length() == 1 && points.get(j).length() == 1 && points.get(a).length() == 1){
								return false;
							}						
							//if (i,a) or (a,j) were blue, it should now be green.
							pair.clear();
							computePair(a, i, pair, points);
							
							pair.clear();
							computePair(a, j, pair, points);
							
							for(int firstPoint = j; firstPoint != a; firstPoint = (firstPoint+1)%points.size()){							
								for(int secondPoint = (a+1)%points.size(); secondPoint != i+1; secondPoint = (secondPoint+1)%points.size()){								
									pair.clear();
									computePair(firstPoint, secondPoint, pair, points);								
									String theirColor = edgeColor.get(pair);								
									if(cannotBlock(theirColor)){
										return false;
									}
									else{
										updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
									}								
								}
							}
							
							//For all points x on CCW side s.t. (i,x) and (j,x) are green, red, or yellow (not too far away), then (a,x) cannot be too far away.
							//For all points x on CCW side s.t. (a,x) is purple, x must be purple to at least one of i and j.						
							for(int x = i+1; x < j; x++){							
								computePair(x, a, pair, points);
								String axColor = edgeColor.get(pair);
								
								if(axColor.equalsIgnoreCase("green")){								
									continue;
								}
								
								boolean xSeesPointBetweenJandA = false;
								for(int w = j; w != a; w = (w+1)%points.size()){								
									computePair(x, w, pair, points);
									if(edgeColor.get(pair).equalsIgnoreCase("green")){
										xSeesPointBetweenJandA = true;
										break;
									}
								}							
								
								boolean xSeesPointBetweenAandI = false;
								for(int w = (a+1)%points.size(); w != i+1; w = (w+1)%points.size()){								
									computePair(x, w, pair, points);
									if(edgeColor.get(pair).equalsIgnoreCase("green")){
										xSeesPointBetweenAandI = true;
										break;
									}
								}							
								
								if(xSeesPointBetweenJandA && xSeesPointBetweenAandI){								
									if(cannotSee(axColor)){									
										return false;
									}
									else{									
										computePair(x, a, pair, points);
										edgeColor.replace(pair,"green");
										updatedAnEdge = true;
										continue;
									}
								}
								else if(xSeesPointBetweenJandA){								
									if(mustBlock(axColor)){									
										for(int w = (a+1)%points.size(); w != i+1; w = (w+1)%points.size()){										
											computePair(x, w, pair, points);
											String xwColor = edgeColor.get(pair);
											if(cannotBlock(xwColor)){											
												return false;
											}
											else{											
												updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
											}
										}
									}
									else if(mustBeFar(axColor)){									
										boolean foundCloseXBlueA = false;
										int w = i;
										while(w != a){
											computePair(x, w, pair, points);
											String xwColor = edgeColor.get(pair);
											
											if(!foundCloseXBlueA && mustBeClose(xwColor)){											
												computePair(a, w, pair, points);
												String awColor = edgeColor.get(pair);											
												if(cannotBlock(awColor)){
													foundCloseXBlueA = true;
												}											
											}
											
											if(xwColor.equalsIgnoreCase("green")){												
												return false;
											}
											else{											
												if(!foundCloseXBlueA){
													updatedAnEdge = makeEdgeNotVisible(edgeColor,pair) || updatedAnEdge;
												}
												else{
													
													for(int pointToBlock = x; pointToBlock != a; pointToBlock = (pointToBlock+1)%points.size()){													
														computePair(pointToBlock, w, pair, points);
														String ptbwColor = edgeColor.get(pair);
														if(cannotBlock(ptbwColor)){
															return false;
														}
														else{
															updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
														}													
													}
												}
											}										
											w--;
											if(w == -1){
												w = points.size()-1;
											}
										}									
									}
								}
								else if(xSeesPointBetweenAandI){								
									if(mustBlock(axColor)){									
										for(int w = j; w< a; w = (w+1)%points.size()){										
											computePair(x, w, pair, points);
											String xwColor = edgeColor.get(pair);
											if(cannotBlock(xwColor)){											
												return false;
											}
											else{											
												updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
											}
										}
									}
									else if(mustBeFar(axColor)){																		
										boolean foundCloseXBlueA = false;
										for(int w = j; w != a; w = (w+1)%points.size()){										
											computePair(x, w, pair, points);
											String xwColor = edgeColor.get(pair);
											
											if(!foundCloseXBlueA && mustBeClose(xwColor)){											
												computePair(a, w, pair, points);
												String awColor = edgeColor.get(pair);
												
												if(cannotBlock(awColor)){
													foundCloseXBlueA = true;
												}
												
											}
											
											if(xwColor.equalsIgnoreCase("green")){											
												return false;
											}
											else{
												
												if(!foundCloseXBlueA){
													updatedAnEdge = makeEdgeNotVisible(edgeColor,pair) || updatedAnEdge;
												}
												else{																								
													for(int pointToBlock = (a+1)%points.size(); pointToBlock != x+1; pointToBlock = (pointToBlock+1)%points.size()){													
														computePair(pointToBlock, w, pair, points);
														String ptbwColor = edgeColor.get(pair);
														if(cannotBlock(ptbwColor)){
															return false;
														}
														else{
															updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
														}													
													}
												}
											}
										}									
									}
								}
							}
						}
						
						if(blockers.size() == 0){						
							//Every point x \in [j,a) must be red to every point w \in (b,i].
							//If i wasn't blue to anything in (j,i), then b==i.  It still can be blocked from points in [j,a).
							int startingIndexForX = (b+1)%points.size();
							if(b == i){							
								startingIndexForX = i;
							}
							for(int x = startingIndexForX; x!=(i+1)%points.size(); x=(x+1)%points.size()){							
								int stoppingIndexForW = a;
								if(j==a){
									stoppingIndexForW = (a+1)%points.size();
								}
								for(int w = j; w != stoppingIndexForW; w = (w+1)%points.size()){								
									computePair(w, x, pair, points);
									String theirColor = edgeColor.get(pair);								
									if(theirColor == null){									
										printToOutputFile("j: " + points.get(j) + ", a: " + points.get(a) + ", b: " + points.get(b) + ", i: " + points.get(i));
										printToOutputFile("w: " + points.get(w) + ", x: " + points.get(x));
									}								
									if(cannotBlock(theirColor)){									
										return false;
									}
									else{									
										updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;								
									}
								}
							}
						}										
					}
				}			
			}						
		} while (updatedAnEdge);
		
		if(writeEdgeColor){
			try{
				for(Map.Entry<ArrayList<String>, String> entry: edgeColor.entrySet()) {				
					ArrayList<String> thePair = entry.getKey();				
					if(thePair.get(0).length() == 1 && thePair.get(1).length() == 1){
						String theColor = edgeColor.get(thePair);
						if(theColor.equals("YELLOW")) {
							edgeColor.replace(thePair,"yellow");
						}					
					}				
				}
				
				String key = "edgeColor" + points.size();
				allTheMaps.put(key, edgeColor);
			}
			catch(Exception e){
				e.printStackTrace();
			}		
		}
		
		return true;
	}
	//End isFeasibleOrdering
	
	public static int checkForbiddenSubgraphs(HashMap<ArrayList<String>,String> edgeColor){				
		boolean updatedAnEdge = false;
		int oneGapEdgeResult = checkAllOneGapEdges(edgeColor);
		if(oneGapEdgeResult == 0){
			return 0;
		}
		else if(oneGapEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		oneGapEdgeResult = checkEveryThirdOneGapEdge(edgeColor);
		if(oneGapEdgeResult == 0){
			return 0;
		}
		else if(oneGapEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		oneGapEdgeResult = checkFirstAndFourthOneGapEdge(edgeColor);
		if(oneGapEdgeResult == 0){
			return 0;
		}
		else if(oneGapEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		oneGapEdgeResult = checkAdjacentOneGapEdges(edgeColor);
		if(oneGapEdgeResult == 0){
			return 0;
		}
		else if(oneGapEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		int twoGapEdgeResult = checkTwoGapEdges(edgeColor);
		if(twoGapEdgeResult == 0){
			return 0;
		}
		else if(twoGapEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		twoGapEdgeResult = checkAllTwoGapEdges(edgeColor);
		if(twoGapEdgeResult == 0){
			return 0;
		}
		else if(twoGapEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		int triangleEdgeResult = checkTriangleEdges(edgeColor);
		if(triangleEdgeResult == 0){
			return 0;
		}
		else if(triangleEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		triangleEdgeResult = checkAllTriangleEdges(edgeColor);
		if(triangleEdgeResult == 0){
			return 0;
		}
		else if(triangleEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		int triangleResult = checkTriangles(edgeColor);
		if(triangleResult == 0){
			return 0;
		}
		else if(triangleResult == 1){
			updatedAnEdge = true;
		}
		
		int twoTriangleEdgeResult = checkTwoTriangleEdges(edgeColor,2,7);
		if(twoTriangleEdgeResult == 0){
			return 0;
		}
		else if(twoTriangleEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		twoTriangleEdgeResult = checkTwoTriangleEdges(edgeColor,1,7);
		if(twoTriangleEdgeResult == 0){
			return 0;
		}
		else if(twoTriangleEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		twoTriangleEdgeResult = checkTwoTriangleEdges(edgeColor,2,8);
		if(twoTriangleEdgeResult == 0){
			return 0;
		}
		else if(twoTriangleEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		twoTriangleEdgeResult = checkTwoTriangleEdges(edgeColor,1,8);
		if(twoTriangleEdgeResult == 0){
			return 0;
		}
		else if(twoTriangleEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		twoTriangleEdgeResult = checkTwoTriangleEdges2(edgeColor);
		if(twoTriangleEdgeResult == 0){
			return 0;
		}
		else if(twoTriangleEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		//F,G 
		int threeFourEdgeResult = checkThreeFourEdgePattern(edgeColor,2,3);
		if(threeFourEdgeResult == 0){
			return 0;
		}
		else if(threeFourEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		//E,F 
		threeFourEdgeResult = checkThreeFourEdgePattern(edgeColor,1,2);
		if(threeFourEdgeResult == 0){
			return 0;
		}
		else if(threeFourEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		//G,H 
		threeFourEdgeResult = checkThreeFourEdgePattern(edgeColor,3,4);
		if(threeFourEdgeResult == 0){
			return 0;
		}
		else if(threeFourEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		//E,G 
		threeFourEdgeResult = checkThreeFourEdgePattern(edgeColor,1,3);
		if(threeFourEdgeResult == 0){
			return 0;
		}
		else if(threeFourEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		//F,H 
		threeFourEdgeResult = checkThreeFourEdgePattern(edgeColor,2,4);
		if(threeFourEdgeResult == 0){
			return 0;
		}
		else if(threeFourEdgeResult == 1){
			updatedAnEdge = true;
		}
		
		//E,H 
		threeFourEdgeResult = checkThreeFourEdgePattern(edgeColor,1,4);
		if(threeFourEdgeResult == 0){
			return 0;
		}
		else if(threeFourEdgeResult == 1){		
			updatedAnEdge = true;
		}
		
		//WeirdBox0 
		int boxResult = boxChecker(1,1,1,edgeColor);
		if(boxResult == 0)
		{
			return 0;
		}
		else if(boxResult == 1){
			
			updatedAnEdge = true;
		}
		
		//WeirdBox1 CCW 
		boxResult = boxChecker(1,0,2,edgeColor);
		if(boxResult == 0)
		{
			return 0;
		}
		else if(boxResult == 1){			
			updatedAnEdge = true;
		}
		
		//WeirdBox1 CW 
		boxResult = boxChecker(0,1,2,edgeColor);
		if(boxResult == 0)
		{
			return 0;
		}
		else if(boxResult == 1){			
			updatedAnEdge = true;
		}
		
		//WeirdBox2
		boxResult = boxChecker(1,2,0,edgeColor);
		if(boxResult == 0)
		{
			return 0;
		}
		else if(boxResult == 1){			
			updatedAnEdge = true;
		}
		
		if(updatedAnEdge){
			return 1;
		} else{
			return 2;
		}
	}
	
	public static int checkTriangleEdgeBlockers(ArrayList<String> points,HashMap<ArrayList<String>,String> edgeColor){		
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		for(int blockedPoint = 0; blockedPoint < guards.length; blockedPoint++){			
			int trianglePoint1 = (blockedPoint+3)%guards.length;
			int trianglePoint2 = (blockedPoint+6)%guards.length;
			
			int numPinkEdges = 0;
			int numSidesNotBlockedOverGuard = 0;
			
			computeGuardPair(blockedPoint,trianglePoint1,pair);
			String firstEdge = edgeColor.get(pair);
			
			if(mustBlock(firstEdge)){
				numPinkEdges++;
			}
			
			computeGuardPair(blockedPoint,trianglePoint2,pair);
			String secondEdge = edgeColor.get(pair);
			
			if(mustBlock(secondEdge)){
				numPinkEdges++;
			}
			
			if(numPinkEdges == 0){
				continue;
			}
			
			int indexOfBlockedPoint = 0;
			while(!points.get(indexOfBlockedPoint).equals(guards[blockedPoint])){
				indexOfBlockedPoint++;
			}
			
			int nextGuardIndex = (indexOfBlockedPoint+1)%points.size();
			while(points.get(nextGuardIndex).length() > 1){
				nextGuardIndex = (nextGuardIndex+1)%points.size();
			}
			
			int indexOfTrianglePoint1 = (nextGuardIndex+1)%points.size();
			while(!points.get(indexOfTrianglePoint1).equals(guards[trianglePoint1])){
				indexOfTrianglePoint1 = (indexOfTrianglePoint1+1)%points.size();
			}
			
			int i = nextGuardIndex;
			do{
				computePair(indexOfBlockedPoint, i, pair, points);
				if(edgeColor.get(pair).equalsIgnoreCase("green")){
					
					computePair(indexOfTrianglePoint1, i, pair, points);
					if(edgeColor.get(pair).equalsIgnoreCase("green")){
						numSidesNotBlockedOverGuard++;
						break;
					}
				}				
				i = (i+1)%points.size();				
			}while(i != indexOfTrianglePoint1);
			
			//Reverse direction.
			nextGuardIndex = (indexOfBlockedPoint-1+points.size())%points.size();
			while(points.get(nextGuardIndex).length() > 1){
				nextGuardIndex = (nextGuardIndex-1+points.size())%points.size();
			}
			
			int indexOfTrianglePoint2 = (nextGuardIndex-1+points.size())%points.size();
			while(!points.get(indexOfTrianglePoint2).equals(guards[trianglePoint2])){
				indexOfTrianglePoint2 = (indexOfTrianglePoint2-1+points.size())%points.size();
			}
			
			i = nextGuardIndex;
			do{
				computePair(indexOfBlockedPoint, i, pair, points);
				if(edgeColor.get(pair).equalsIgnoreCase("green")){					
					computePair(indexOfTrianglePoint2, i, pair, points);
					if(edgeColor.get(pair).equalsIgnoreCase("green")){
						numSidesNotBlockedOverGuard++;
						break;
					}					
				}				
				i = (i-1+points.size())%points.size();				
			}while(i != indexOfTrianglePoint2);
			
			if(numPinkEdges == 2 && numSidesNotBlockedOverGuard == 2){
				//We don't have a blocker near the blocked guard and we can reject.
				return 0;
			}
			else if(numPinkEdges == 1 && numSidesNotBlockedOverGuard == 2){				
				//We can make the non-pink triangle edge not blocked.
				if(mustBlock(firstEdge)){					
					computeGuardPair(blockedPoint,trianglePoint2,pair);
					updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;				
				}
				else{					
					computeGuardPair(blockedPoint,trianglePoint1,pair);
					updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
				}
			}			
		}		  		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}
	}
	
	public static int checkThreeFourEdgeBlockers(ArrayList<String> points,HashMap<ArrayList<String>,String> edgeColor){		
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		//blockedPoint = D
		for(int blockedPoint = 0; blockedPoint < guards.length; blockedPoint++){			
			//otherBlocked = I
			int otherBlocked = (blockedPoint+5)%guards.length;
			computeGuardPair(blockedPoint,otherBlocked,pair);
			String threeFourEdgeColor = edgeColor.get(pair);			
			if(cannotBlock(threeFourEdgeColor)){
				continue;
			}
			
			boolean threeFourEdgeIsPink = mustBlock(threeFourEdgeColor);
			
			int indexOfBlockedPoint = 0;
			while(!points.get(indexOfBlockedPoint).equals(guards[blockedPoint])){
				indexOfBlockedPoint++;
			}
			
			int indexOfOtherBlocked = 0;
			while(!points.get(indexOfOtherBlocked).equals(guards[otherBlocked])){
				indexOfOtherBlocked++;
			}
			
			//guard1 = E
			int guard1 = (blockedPoint+1)%guards.length;
			
			int indexOfGuard1 = 0;
			while(!points.get(indexOfGuard1).equals(guards[guard1])){
				indexOfGuard1++;
			}
			
			//guard2 = H
			String guard2 = guards[(blockedPoint+4)%guards.length];
			
			boolean thereIsBluePointToBothBlocked = false;
			int i=(indexOfGuard1+1)%points.size();
			while(!points.get(i).equals(guard2)){				
				computePair(indexOfBlockedPoint, i, pair, points);
				if(cannotBlock(edgeColor.get(pair))){					
					computePair(indexOfOtherBlocked, i, pair, points);
					if(cannotBlock(edgeColor.get(pair))){
						thereIsBluePointToBothBlocked = true;
						break;
					}
				}				
				i = (i+1)%points.size();
			}
			
			boolean blueEdgesCrossOnTop = false;
			int firstBlueToBlockedPoint = (indexOfOtherBlocked+1)%points.size();
			while(firstBlueToBlockedPoint != indexOfBlockedPoint){				
				computePair(indexOfBlockedPoint, firstBlueToBlockedPoint, pair, points);
				if(cannotBlock(edgeColor.get(pair))){
					break;
				}				
				firstBlueToBlockedPoint = (firstBlueToBlockedPoint+1)%points.size();
			}
			
			int indexOfBlueToOtherBlocked = -1;
			if(firstBlueToBlockedPoint != indexOfBlockedPoint){
				
				indexOfBlueToOtherBlocked = (firstBlueToBlockedPoint+1)%points.size();
				while(indexOfBlueToOtherBlocked != indexOfBlockedPoint){					
					computePair(indexOfOtherBlocked, indexOfBlueToOtherBlocked, pair, points);
					if(cannotBlock(edgeColor.get(pair))){
						blueEdgesCrossOnTop = true;
						break;
					}					
					indexOfBlueToOtherBlocked = (indexOfBlueToOtherBlocked+1)%points.size();
				}				
			}
			
			if(threeFourEdgeIsPink && thereIsBluePointToBothBlocked && blueEdgesCrossOnTop){
				//Would have to block the threeFour edge with a blocker between guard1 and guard 2.  Reject.
				return 0;
			}
			else if(thereIsBluePointToBothBlocked && blueEdgesCrossOnTop){				
				//We can make the threeFour edge not blocked.
				computeGuardPair(blockedPoint,otherBlocked,pair);
				updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;			
			}
			else if(threeFourEdgeIsPink && thereIsBluePointToBothBlocked){				
				//If these are equal then blockedPoint isn't blue to anything.
				if(firstBlueToBlockedPoint != indexOfBlockedPoint){
					//Make otherBlocked pink to all points in (firstBlueToBlockedPoint, blockedPoint).
					i = (firstBlueToBlockedPoint+1)%points.size();
					while(i != indexOfBlockedPoint){						
						computePair(indexOfOtherBlocked, i, pair, points);
						//if(pair.get(0).equals("BDFH") && pair.get(1).equals("I")) printToOutputFile(guards[blockedPoint] + ", " + guards[otherBlocked] + ": can't cross above.");
						updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;						
						i = (i+1)%points.size();
					}
				}
				
				//Find first blue to otherBlocked so we can do the same for blocked point.
				int firstBlueToOtherBlocked = firstBlueToBlockedPoint;
				while(firstBlueToOtherBlocked != indexOfOtherBlocked){					
					computePair(indexOfOtherBlocked, firstBlueToOtherBlocked, pair, points);
					if(cannotBlock(edgeColor.get(pair))){
						break;
					}					
					firstBlueToOtherBlocked = (firstBlueToOtherBlocked + points.size() - 1)%points.size();
				}
				
				//If these are equal then otherBlocked isn't blue to anything.
				if(firstBlueToOtherBlocked != indexOfOtherBlocked){					
					i = (firstBlueToOtherBlocked + points.size() - 1)%points.size();
					while(i != indexOfOtherBlocked){						
						computePair(indexOfBlockedPoint, i, pair, points);
						updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;						
						i = (i + points.size() - 1)%points.size();
					}					
				}
			}
			else if(threeFourEdgeIsPink && blueEdgesCrossOnTop){				
				//If a point between guard1 and guard2 is blue to one of them, then it has to be pink to the other.
				i = (indexOfGuard1 + 1)%points.size();
				while(!points.get(i).equals(guard2)){					
					computePair(indexOfBlockedPoint, i, pair, points);
					if(cannotBlock(edgeColor.get(pair))){						
						computePair(indexOfOtherBlocked, i, pair, points);
						updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
					}
					else{						
						computePair(indexOfOtherBlocked, i, pair, points);
						if(cannotBlock(edgeColor.get(pair))){							
							computePair(indexOfBlockedPoint, i, pair, points);
							updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
						}						
					}					
					i = (i+1)%points.size();
				}				
			}		
		}		  
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}
	}	
	
	public static int checkThreeFourEdgePattern(HashMap<ArrayList<String>,String> edgeColor, int blueUnder1, int blueUnder2){				
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		//blockedPoint = D
		for(int blockedPoint = 0; blockedPoint < guards.length; blockedPoint++){			
			//otherBlocked = I
			int otherBlocked = (blockedPoint+5)%guards.length;
			computeGuardPair(blockedPoint,otherBlocked,pair);
			String threeFourEdgeColor = edgeColor.get(pair);
			
			if(cannotBlock(threeFourEdgeColor)){
				continue;
			}
			
			boolean threeFourEdgeIsPink = mustBlock(threeFourEdgeColor);
			
			//guard1 = F
			int guard1 = (blockedPoint+blueUnder1)%guards.length;
			
			//guard2 = G
			int guard2 = (blockedPoint+blueUnder2)%guards.length;
			
			int numBlueGuardsBelow = 0;
			computeGuardPair(blockedPoint,guard1,pair);
			String bottomEdge1 = edgeColor.get(pair);
			if(cannotBlock(bottomEdge1)){
				numBlueGuardsBelow++;
			}else if(mustBlock(bottomEdge1)){
				continue;
			}
			
			computeGuardPair(otherBlocked,guard2,pair);
			String bottomEdge2 = edgeColor.get(pair);
			if(cannotBlock(bottomEdge2)){
				numBlueGuardsBelow++;
			}else if(mustBlock(bottomEdge2)){
				continue;
			}
			if(numBlueGuardsBelow == 0 || (numBlueGuardsBelow==1 && !threeFourEdgeIsPink)){
				continue;
			}
			
			boolean possibleToReject = threeFourEdgeIsPink && numBlueGuardsBelow == 2;
			
			for(int firstTop = 6; firstTop <= 8; firstTop++){				
				int firstTopGuard = (blockedPoint+firstTop)%guards.length;
				computeGuardPair(blockedPoint,firstTopGuard,pair);
				String topEdge1 = edgeColor.get(pair);
				boolean edge1IsBlue = false;
				if(cannotBlock(topEdge1)){
					edge1IsBlue = true;
				}else if(mustBlock(topEdge1)){
					continue;
				}
				
				if(!possibleToReject && !edge1IsBlue){
					continue;
				}
				
				
				for(int secondTop = firstTop; secondTop <= 8; secondTop++){										
					int secondTopGuard = (blockedPoint+secondTop)%guards.length;
					computeGuardPair(otherBlocked,secondTopGuard,pair);
					String topEdge2 = edgeColor.get(pair);
					boolean edge2IsBlue = false;
					if(cannotBlock(topEdge2)){
						edge2IsBlue = true;
					}else if(mustBlock(topEdge2)){
						continue;
					}
					
					if(!possibleToReject && !edge2IsBlue){
						continue;
					}
					
					if(!edge1IsBlue && !edge2IsBlue){
						continue;
					}
					
					if(possibleToReject && edge1IsBlue && edge2IsBlue){
						return 0;
					}
					else if(!possibleToReject && edge1IsBlue && edge2IsBlue){						
						//Both top edges are blue.  Can flip threeFour or the bottom edge.
						if(!threeFourEdgeIsPink){							
							computeGuardPair(otherBlocked,blockedPoint,pair);
							updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
						}
						else if(cannotBlock(bottomEdge1)){							
							computeGuardPair(otherBlocked,guard2,pair);
							updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;							
						}
						else{
							computeGuardPair(blockedPoint,guard1,pair);
							updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;							
						}		
					}
					else if(possibleToReject){						
						if(edge1IsBlue){							
							computeGuardPair(otherBlocked,secondTopGuard,pair);
							updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
						}
						else{							
							computeGuardPair(blockedPoint,firstTopGuard,pair);
							updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
						}						
					}					
				}		
			}						
		}		  		
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}
	}
	
	public static int checkTriangles(HashMap<ArrayList<String>,String> edgeColor){		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		//firstPoint can be A, B, or C.
		for(int firstPoint = 0; firstPoint < 3; firstPoint++){			
			int secondPoint = firstPoint+3;
			int thirdPoint = firstPoint+6;
			
			computeGuardPair(firstPoint,secondPoint,pair);
			String firstToSecond = edgeColor.get(pair);
			
			computeGuardPair(firstPoint,thirdPoint,pair);
			String firstToThird = edgeColor.get(pair);
			
			computeGuardPair(secondPoint,thirdPoint,pair);
			String secondToThird = edgeColor.get(pair);
			
			int numPinkEdges = 0;
			int firstBlue = -1;
			int secondBlue = -1;
			
			if(mustBlock(firstToSecond)){
				numPinkEdges++;
			}else{
				firstBlue = firstPoint;
				secondBlue = secondPoint;
			}
			
			if(mustBlock(firstToThird)){
				numPinkEdges++;
			}else{
				firstBlue = firstPoint;
				secondBlue = thirdPoint;
			}
			
			if(mustBlock(secondToThird)){
				numPinkEdges++;
			} else{
				firstBlue = secondPoint;
				secondBlue = thirdPoint;
			}
			
			if(numPinkEdges == 3){
				return 0;
			}else if(numPinkEdges == 2){				
				computeGuardPair(firstBlue,secondBlue,pair);
				updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
			}						
		}
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}
		
	}
	
	public static int checkTriangleEdges(HashMap<ArrayList<String>,String> edgeColor){		
		//return 0 if we can reject it, return 1 if we cannot reject and flipped an edge, return 2 ow.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		for(int firstPoint = 0; firstPoint < guards.length; firstPoint++){
			
			int fourthPoint = (firstPoint+3)%guards.length;
			int thirdPoint = (firstPoint+2)%guards.length;
			int secondPoint = (firstPoint+1)%guards.length;
			
			computeGuardPair(firstPoint,fourthPoint,pair);
			String firstToFourth = edgeColor.get(pair);
			
			computeGuardPair(firstPoint,thirdPoint,pair);
			String firstToThird = edgeColor.get(pair);
			
			computeGuardPair(firstPoint,secondPoint,pair);
			String firstToSecond = edgeColor.get(pair);
			
			computeGuardPair(secondPoint,fourthPoint,pair);
			String secondToFourth = edgeColor.get(pair);
			
			computeGuardPair(thirdPoint,fourthPoint,pair);
			String thirdToFourth = edgeColor.get(pair);
			
			boolean haveBlueStuff = (cannotBlock(firstToThird) && cannotBlock(secondToFourth)) || (cannotBlock(firstToSecond) && cannotBlock(secondToFourth)) || (cannotBlock(firstToThird) && cannotBlock(thirdToFourth));
			
			if(mustBlock(firstToFourth)){				
				if(haveBlueStuff){
					return 0;
				}else{ 					
					if(cannotBlock(firstToThird)){
						computeGuardPair(secondPoint,fourthPoint,pair);
						updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
						
						computeGuardPair(thirdPoint,fourthPoint,pair);
						updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
					}
					
					if(cannotBlock(secondToFourth)){
						computeGuardPair(firstPoint,thirdPoint,pair);
						updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
						
						computeGuardPair(firstPoint,secondPoint,pair);
						updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
					}
					
					if(cannotBlock(firstToSecond)){
						computeGuardPair(secondPoint,fourthPoint,pair);
						updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;					  
					}
					
					if(cannotBlock(thirdToFourth)){
						computeGuardPair(firstPoint,thirdPoint,pair);
						updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
					}
				}
			}
			else if(haveBlueStuff){				
				computeGuardPair(firstPoint,fourthPoint,pair);
				updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
			}			
		}		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}
	}
	
	public static int checkTwoTriangleEdges(HashMap<ArrayList<String>,String> edgeColor, int blue1, int blue2){		
		//return 0 if we can reject it, return 1 if we cannot reject and flipped an edge, return 2 ow.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		for(int blockedPoint = 0; blockedPoint < guards.length; blockedPoint++){
			
			int trianglePoint1 = (blockedPoint+3)%guards.length;
			int trianglePoint2 = (blockedPoint+6)%guards.length;
			
			int numPinkEdges = 0;
			int numBlueEdges = 0;
			
			computeGuardPair(blockedPoint,trianglePoint1,pair);
			String firstEdge = edgeColor.get(pair);
			
			if(mustBlock(firstEdge)){
				numPinkEdges++;
			}
			
			computeGuardPair(blockedPoint,trianglePoint2,pair);
			String secondEdge = edgeColor.get(pair);
			
			if(mustBlock(secondEdge)){
				numPinkEdges++;
			}
			
			if(numPinkEdges == 0){
				continue;
			}
			
			int bluePoint1 = (blockedPoint+blue1)%guards.length;
			int bluePoint2 = (blockedPoint+blue2)%guards.length;
			
			computeGuardPair(blockedPoint,bluePoint1,pair);
			String thirdEdge = edgeColor.get(pair);
			
			if(cannotBlock(thirdEdge)){
				numBlueEdges++;
			}
			
			computeGuardPair(blockedPoint,bluePoint2,pair);
			String fourthEdge = edgeColor.get(pair);
			
			if(cannotBlock(fourthEdge)){
				numBlueEdges++;
			}
			
			if(numPinkEdges == 2 && numBlueEdges == 2){
				return 0;
			}
			else if(numBlueEdges == 2){				
				if(mustBlock(firstEdge)){					
					computeGuardPair(blockedPoint,trianglePoint2,pair);
					updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
				}
				else{					
					computeGuardPair(blockedPoint,trianglePoint1,pair);
					updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
				}				
			}
			else if(numPinkEdges == 2 && numBlueEdges == 1){				
				if(cannotBlock(thirdEdge)){					
					computeGuardPair(blockedPoint,bluePoint2,pair);
					updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
				}
				else{
					computeGuardPair(blockedPoint,bluePoint1,pair);
					updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;					
				}
			}
		}
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}
	}
	
	//This function checks where the blues are adjacent to trianglePoints 1 and 2, not blockedPoint.
	public static int checkTwoTriangleEdges2(HashMap<ArrayList<String>,String> edgeColor){		
		//return 0 if we can reject it, return 1 if we cannot reject and flipped an edge, return 2 ow.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		for(int blockedPoint = 0; blockedPoint < guards.length; blockedPoint++){
			
			int trianglePoint1 = (blockedPoint+3)%guards.length;
			int trianglePoint2 = (blockedPoint+6)%guards.length;
			
			int numPinkEdges = 0;
			int numBlueEdges = 0;
			
			computeGuardPair(blockedPoint,trianglePoint1,pair);
			String firstEdge = edgeColor.get(pair);
			
			if(mustBlock(firstEdge)){
				numPinkEdges++;
			}
			
			computeGuardPair(blockedPoint,trianglePoint2,pair);
			String secondEdge = edgeColor.get(pair);
			
			if(mustBlock(secondEdge)){
				numPinkEdges++;
			}
			
			if(numPinkEdges == 0){
				continue;
			}
			
			int bluePoint1 = (blockedPoint+1)%guards.length;
			int bluePoint2 = (blockedPoint+8)%guards.length;
			
			computeGuardPair(trianglePoint1,bluePoint1,pair);
			String thirdEdge = edgeColor.get(pair);
			
			if(cannotBlock(thirdEdge)){
				numBlueEdges++;
			}
			
			computeGuardPair(trianglePoint2,bluePoint2,pair);
			String fourthEdge = edgeColor.get(pair);
			
			if(cannotBlock(fourthEdge)){
				numBlueEdges++;
			}
			
			if(numPinkEdges == 2 && numBlueEdges == 2){
				return 0;
			}
			else if(numBlueEdges == 2){				
				if(mustBlock(firstEdge)){					
					computeGuardPair(blockedPoint,trianglePoint2,pair);
					updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
				}
				else{					
					computeGuardPair(blockedPoint,trianglePoint1,pair);
					updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
				}				
			}
			else if(numPinkEdges == 2 && numBlueEdges == 1){				
				if(cannotBlock(thirdEdge)){					
					computeGuardPair(trianglePoint2,bluePoint2,pair);
					updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
				}
				else{
					computeGuardPair(trianglePoint1,bluePoint1,pair);
					updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;					
				}
			}
		}
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}
	}
	
	public static int checkTwoGapEdges(HashMap<ArrayList<String>,String> edgeColor){		
		//return 0 if we can reject it, return 1 if we cannot reject and flipped an edge, return 2 ow.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		for(int firstPoint = 0; firstPoint < guards.length; firstPoint++){			
			int thirdPoint = (firstPoint+2)%guards.length;
			int secondPoint = (firstPoint+1)%guards.length;
			
			computeGuardPair(firstPoint,thirdPoint,pair);
			String firstToThird = edgeColor.get(pair);
			
			computeGuardPair(firstPoint,secondPoint,pair);
			String firstToSecond = edgeColor.get(pair);
			
			computeGuardPair(secondPoint,thirdPoint,pair);
			String secondToThird = edgeColor.get(pair);						
			
			if(mustBlock(firstToThird)){				
				if(cannotBlock(firstToSecond) && cannotBlock(secondToThird)){
					return 0;
				}else if(cannotBlock(firstToSecond)){
					updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
				}
				else if(cannotBlock(secondToThird)){
					computeGuardPair(firstPoint,secondPoint,pair);
					updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
				}
			}
			else if(cannotBlock(firstToSecond) && cannotBlock(secondToThird)){				
				computeGuardPair(firstPoint,thirdPoint,pair);
				updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
			}
			
		}
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}		
	}
	
	//There must be at least two pink two-gap edges.
	//If exactly two, we can reject if specific triangle edges are both pink.
	public static int checkAllTwoGapEdges(HashMap<ArrayList<String>,String> edgeColor){		
		//return 0 if we can reject it, return 1 if we cannot reject and flipped an edge, return 2 ow.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		int numBlueEdges = 0;
		int numPinkEdges = 0;
		
		int pinkGuard1 = -1;
		int pinkGuard2 = -1;
		
		int pinkGuard3 = -1;
		int pinkGuard4 = -1;
		
		for(int firstPoint = 0; firstPoint < guards.length; firstPoint++){			
			//>7 blue => reject.
			//7 blue => other two must be pink.
			//<7 blue => Can't do anything....come on, bill gates.
			
			int thirdPoint = (firstPoint+2)%guards.length;			
			computeGuardPair(firstPoint,thirdPoint,pair);
			String firstToThird = edgeColor.get(pair);			
			
			if(mustBlock(firstToThird)){				
				numPinkEdges++;				
				if(numPinkEdges > 2){
					return 2;
				}
				
			}
			else if(cannotBlock(firstToThird)){				
				numBlueEdges++;				
				if(numBlueEdges > 7){
					return 0;
				}
			}		  
			else{
				//This edge is "cyan".				
				if(pinkGuard3 != -1){
					//If we already had another cyan edge, nothing to do here.
					return 2;
				}
				else if(pinkGuard1 == -1){					
					pinkGuard1 = firstPoint;
					pinkGuard2 = thirdPoint;
				}
				else{
					pinkGuard3 = firstPoint;
					pinkGuard4 = thirdPoint;
				}				
			}			
		}
		
		if(numPinkEdges == 2){			
			if(numBlueEdges==7){				
				int result = checkExtraTriangleEdges(edgeColor);
				if(result == 0)
				return 0;
				else if(result == 1)
				updatedAnEdge = true;
			}
		}
		else{			
			//If we make it here, there is <=2 cyan, <8 blue, <2 pink.  So it's 1-7-1, 2-7-0, or 2-6-1.			
			if(numBlueEdges == 7){				
				computeGuardPair(pinkGuard1,pinkGuard2,pair);
				updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
				
				if(pinkGuard3 != -1){
					computeGuardPair(pinkGuard3,pinkGuard4,pair);
					updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
				}				
			}
		}
		
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}		
	}
	
	public static int checkExtraTriangleEdges(HashMap<ArrayList<String>,String> edgeColor){		
		//return 0 if we can reject it, return 1 if we cannot reject and flipped an edge, return 2 ow.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};
		
		ArrayList<String> pair = new ArrayList<String>();
		
		boolean updatedAnEdge = false;
		
		//We know there are 2 pink and the rest are blue.  
		for(int firstPoint = 0; firstPoint <guards.length; firstPoint++){
			
			int secondPoint = (firstPoint+2)%guards.length;
			
			computeGuardPair(firstPoint,secondPoint,pair);
			String firstEdge = edgeColor.get(pair);
			
			if(!mustBlock(firstEdge)){
				continue;
			}
			
			for(int offset = 1; offset <= 4; offset++){
				
				int thirdPoint = (firstPoint+offset)%guards.length;
				int fourthPoint = (thirdPoint+2)%guards.length;
				
				computeGuardPair(thirdPoint,fourthPoint,pair);
				String secondEdge = edgeColor.get(pair);
				
				if(mustBlock(secondEdge)){					
					//We found the pair we are looking for.  We will return here.
					int triangle1 = (secondPoint+6)%guards.length;
					
					computeGuardPair(secondPoint,triangle1,pair);
					String triEdge1 = edgeColor.get(pair);
					
					int triangle2 = (thirdPoint+3)%guards.length;
					computeGuardPair(thirdPoint,triangle2,pair);
					String triEdge2 = edgeColor.get(pair);
					
					if(mustBlock(triEdge1) && mustBlock(triEdge2)){
						return 0;
					}else if(mustBlock(triEdge1)){						
						computeGuardPair(thirdPoint,triangle2,pair);
						updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
					}
					else if(mustBlock(triEdge2)){						
						computeGuardPair(secondPoint,triangle1,pair);
						updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
					}
					
					if(updatedAnEdge){
						return 1;
					}else{
						return 2;
					}					
				}				
			}									
		}
		//Should never reach this part.
		printToOutputFile("MAJOR ERROR.");
		return 2;
	}
	
	//There must be at least two pink one-gap edges.
	public static int checkAllOneGapEdges(HashMap<ArrayList<String>,String> edgeColor){		
		//return 0 if we can reject it, return 1 if we cannot reject and flipped an edge, return 2 ow.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};
		
		ArrayList<String> pair = new ArrayList<String>();
		
		boolean updatedAnEdge = false;
		
		int numBlueEdges = 0;
		int numPinkEdges = 0;
		
		int pinkGuard1 = -1;
		int pinkGuard2 = -1;
		
		int pinkGuard3 = -1;
		int pinkGuard4 = -1;
		
		for(int firstPoint = 0; firstPoint < guards.length; firstPoint++){			
			//>7 blue => reject.
			//7 blue => other two must be pink.
			//<7 blue => Can't do anything....come on, bill gates.			
			int thirdPoint = (firstPoint+1)%guards.length;
			
			computeGuardPair(firstPoint,thirdPoint,pair);
			String firstToThird = edgeColor.get(pair);			
			
			if(mustBlock(firstToThird)){
				
				numPinkEdges++;
				
				if(numPinkEdges == 2){
					return 2;
				}
				
			}
			else if(cannotBlock(firstToThird)){
				
				numBlueEdges++;
				
				if(numBlueEdges > 7){
					return 0;
				}
			}		  
			else{
				//This edge is "cyan".				
				if(pinkGuard3 != -1){
					//If we already had another cyan edge, nothing to do here.
					return 2;
				}
				else if(pinkGuard1 == -1){					
					pinkGuard1 = firstPoint;
					pinkGuard2 = thirdPoint;
				}
				else{
					pinkGuard3 = firstPoint;
					pinkGuard4 = thirdPoint;
				}				
			}		
		}
		
		//If we make it here, there is <=2 cyan, <8 blue, <2 pink.  So it's 1-7-1, 2-7-0, or 2-6-1.		
		if(numBlueEdges == 7){			
			computeGuardPair(pinkGuard1,pinkGuard2,pair);
			updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;			
			if(pinkGuard3 != -1){
				computeGuardPair(pinkGuard3,pinkGuard4,pair);
				updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
			}		
		}
		
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}
		
	}
	
	public static int checkFirstAndFourthOneGapEdge(HashMap<ArrayList<String>,String> edgeColor){
		
		//We have to have at least 2 pink one-gap edges, but they cannot be separated by 3 blue edges on one side and 4 blue edges on the other.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};
		
		ArrayList<String> pair = new ArrayList<String>();
		
		boolean updatedAnEdge = false;
		
		startingPointLoop:
		for(int startingPoint = 0; startingPoint < guards.length; startingPoint++){			
			int edgeToFlip1 = -1;
			int edgeToFlip2 = -1;
			
			for(int i = 0; i<guards.length; i++){				
				if(i == 0 || i == 4){
					continue;
				}
				
				computeGuardPair((startingPoint+i)%guards.length,(startingPoint+i+1)%guards.length,pair);
				String thisEdge = edgeColor.get(pair);
				
				if(mustBlock(thisEdge)){
					continue startingPointLoop;
				}else if(!cannotBlock(thisEdge)){					
					if(edgeToFlip1 == -1){
						edgeToFlip1 = (startingPoint+i)%guards.length;
						edgeToFlip2 = (startingPoint+i+1)%guards.length;
					}
					else{
						continue startingPointLoop;
					}
				}				
			}
			
			//If we are here, <2 cyan.  0 pink.  Means either 1 cyan and 6 blue, or 0 cyan and 7 blue.
			if(edgeToFlip1 == -1){
				return 0;
			}			
			computeGuardPair(edgeToFlip1,edgeToFlip2,pair);
			updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;						
		}		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;		
		}
	}
	
	public static int checkAdjacentOneGapEdges(HashMap<ArrayList<String>,String> edgeColor){		
		//We have to have at least 2 pink one-gap edges, but they cannot be separated by 3 blue edges on one side and 4 blue edges on the other.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		startingPointLoop:
		for(int startingPoint = 0; startingPoint < guards.length; startingPoint++){
			
			int edgeToFlip1 = -1;
			int edgeToFlip2 = -1;
			
			for(int i = 0; i<7; i++){				
				computeGuardPair((startingPoint+i)%guards.length,(startingPoint+i+1)%guards.length,pair);
				String thisEdge = edgeColor.get(pair);
				
				if(mustBlock(thisEdge))
				continue startingPointLoop;
				else if(!cannotBlock(thisEdge)){					
					if(edgeToFlip1 == -1){
						edgeToFlip1 = (startingPoint+i)%guards.length;
						edgeToFlip2 = (startingPoint+i+1)%guards.length;
					}
					else{
						continue startingPointLoop;
					}
				}				
			}
			
			//If we are here, <2 cyan.  0 pink.  Means either 1 cyan and 6 blue, or 0 cyan and 7 blue.
			if(edgeToFlip1 == -1){
				return 0;
			}
			
			computeGuardPair(edgeToFlip1,edgeToFlip2,pair);
			updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;						
		}
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}		
	}
	
	public static int checkEveryThirdOneGapEdge(HashMap<ArrayList<String>,String> edgeColor){
		
		//return 0 if we can reject it, return 1 if we cannot reject and flipped an edge, return 2 ow.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};
		
		ArrayList<String> pair = new ArrayList<String>();
		
		boolean updatedAnEdge = false;
		
		//Considering every third one gap edge.  Cant have >1 of these pink and the rest blue.
		for(int firstPoint = 0; firstPoint < 3; firstPoint++){
			
			int secondPoint = (firstPoint+1)%guards.length;
			
			int thirdPoint = (firstPoint+3)%guards.length;
			int fourthPoint = (firstPoint+4)%guards.length;
			
			int fifthPoint = (firstPoint+6)%guards.length;
			int sixthPoint = (firstPoint+7)%guards.length;
			
			int otherPoint1 = (firstPoint+2)%guards.length;
			int otherPoint2 = (firstPoint+5)%guards.length;
			int otherPoint3 = (firstPoint+8)%guards.length;
			
			int otherBlues = 0;
			
			int otherEdgeToFlip1 = -1;
			int otherEdgeToFlip2 = -1;  
			
			computeGuardPair(secondPoint,otherPoint1,pair);
			String otherEdge1 = edgeColor.get(pair);
			
			if(mustBlock(otherEdge1)){
				continue;
			}else if(cannotBlock(otherEdge1)){
				otherBlues++;
			}else if(otherEdgeToFlip1 == -1){
				otherEdgeToFlip1 = secondPoint;
				otherEdgeToFlip2 = otherPoint1;
			}else{
				continue;
			}
			
			computeGuardPair(thirdPoint,otherPoint1,pair);
			String otherEdge2 = edgeColor.get(pair);
			
			if(mustBlock(otherEdge2)){
				continue;
			}else if(cannotBlock(otherEdge2)){
				otherBlues++;
			}else if(otherEdgeToFlip1 == -1){
				otherEdgeToFlip1 = thirdPoint;
				otherEdgeToFlip2 = otherPoint1;
			}else{
				continue;
			}
			
			computeGuardPair(fourthPoint,otherPoint2,pair);
			String otherEdge3 = edgeColor.get(pair);
			
			if(mustBlock(otherEdge3)){
				continue;
			}else if(cannotBlock(otherEdge3)){
				otherBlues++;
			}else if(otherEdgeToFlip1 == -1){
				otherEdgeToFlip1 = fourthPoint;
				otherEdgeToFlip2 = otherPoint2;
			}else{
				continue;
			}
			
			computeGuardPair(fifthPoint,otherPoint2,pair);
			String otherEdge4 = edgeColor.get(pair);
			
			if(mustBlock(otherEdge4)){
				continue;
			}else if(cannotBlock(otherEdge4)){
				otherBlues++;
			}else if(otherEdgeToFlip1 == -1){
				otherEdgeToFlip1 = fifthPoint;
				otherEdgeToFlip2 = otherPoint2;
			}else{
				continue;
			}
			
			computeGuardPair(sixthPoint,otherPoint3,pair);
			String otherEdge5 = edgeColor.get(pair);
			
			if(mustBlock(otherEdge5)){
				continue;
			}else if(cannotBlock(otherEdge5)){
				otherBlues++;
			}else if(otherEdgeToFlip1 == -1){
				otherEdgeToFlip1 = sixthPoint;
				otherEdgeToFlip2 = otherPoint3;
			}else{
				continue;
			}
			
			computeGuardPair(firstPoint,otherPoint3,pair);
			String otherEdge6 = edgeColor.get(pair);
			
			if(mustBlock(otherEdge6)){
				continue;
			}else if(cannotBlock(otherEdge6)){
				otherBlues++;
			}else if(otherEdgeToFlip1 == -1){
				otherEdgeToFlip1 = firstPoint;
				otherEdgeToFlip2 = otherPoint3;
			}else{
				continue;
			}
			
			//Have to have at least 2 pinks, but the pinks would have to be critical and we can reject that.
			if(otherBlues == 6){
				return 0;
			}
			
			//If we are here the "other edges" are <2 cyan and <6 blue => 1 cyan and 5 blue.
			//If cyan were blue, we could reject, so flip it to pink.
			computeGuardPair(otherEdgeToFlip1,otherEdgeToFlip2,pair);
			updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;
		}
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}		
	}
	
	//If all triangle edges are blue, we might be able to reject depending on one-gap edges.
	public static int checkAllTriangleEdges(HashMap<ArrayList<String>,String> edgeColor){		
		//return 0 if we can reject it, return 1 if we cannot reject and flipped an edge, return 2 ow.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;		
		
		for(int firstPoint = 0; firstPoint < 3; firstPoint++){			
			int secondPoint = (firstPoint+3)%guards.length;
			int thirdPoint = (firstPoint+6)%guards.length;
			
			computeGuardPair(firstPoint,thirdPoint,pair);
			String firstToThird = edgeColor.get(pair);
			
			computeGuardPair(firstPoint,secondPoint,pair);
			String firstToSecond = edgeColor.get(pair);
			
			computeGuardPair(thirdPoint,secondPoint,pair);
			String secondToThird = edgeColor.get(pair);
			
			if(!cannotBlock(firstToThird)){				
				//Can't do anything right now.
				return 2;
			}		  			
			if(!cannotBlock(firstToSecond)){				
				//Can't do anything right now.
				return 2;
			}		  			
			if(!cannotBlock(secondToThird)){				
				//Can't do anything right now.
				return 2;
			}		  			
		}
		
		//If we make it here, all triangle edges are blue.
		//Check one-gap edges.		
		int numPinkOneGap = 0;
		int numCyanOneGap = 0;
		
		int oneGapToFlip1 = -1;
		int oneGapToFlip2 = -1;
		
		for(int firstPoint = 0; firstPoint<guards.length; firstPoint++){			
			int secondPoint = (firstPoint+1)%guards.length;
			computeGuardPair(firstPoint,secondPoint,pair);
			String firstToSecond = edgeColor.get(pair);
			
			if(mustBlock(firstToSecond)){				
				numPinkOneGap++;
			}	
			else{		
				numCyanOneGap++;				
				oneGapToFlip1 = firstPoint;
				oneGapToFlip2 = secondPoint;
			}						
		}
		
		if(numPinkOneGap >= 4){			
			return 0;
		}
		else if(numPinkOneGap == 3){			
			//All cyans need to be blue.
			if(numCyanOneGap > 0){
				computeGuardPair(oneGapToFlip1,oneGapToFlip2,pair);
				updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;			
				if(numCyanOneGap > 1){					
					for(int firstPoint = 0; firstPoint<guards.length; firstPoint++){						
						int secondPoint = (firstPoint+1)%guards.length;
						computeGuardPair(firstPoint,secondPoint,pair);
						String firstToSecond = edgeColor.get(pair);						
						if(!mustBlock(firstToSecond) && !cannotBlock(firstToSecond)){							
							updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
						}
					}
				}
			}			
			//Now we can check patterns we can reject.
		}
		
		int oneGapResult = oneGaps3P6B(edgeColor);
		if(oneGapResult == 0){
			return 0;		  
		} else if(oneGapResult == 1){
			updatedAnEdge = true;		
		}		
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}		
	}
	
	public static int oneGaps3P6B(HashMap<ArrayList<String>,String> edgeColor){		
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		int numBlueOneGap = 0;
		int numPinkOneGap = 0;
		int numCyanOneGap = 0;
		
		int oneGapToFlip1 = -1;
		int oneGapToFlip2 = -1;				
		
		for(int firstPoint = 0; firstPoint<guards.length; firstPoint++){			
			int secondPoint = (firstPoint+1)%guards.length;
			computeGuardPair(firstPoint,secondPoint,pair);
			String firstToSecond = edgeColor.get(pair);
			
			if(cannotBlock(firstToSecond)){				
				numBlueOneGap++;				
			}
			else if(mustBlock(firstToSecond)){				
				numPinkOneGap++;
			}	
			else{		
				numCyanOneGap++;
				
				oneGapToFlip1 = firstPoint;
				oneGapToFlip2 = secondPoint;
			}						
		}
		
		if(numCyanOneGap > 1){
			return 2;
		}
		
		if(numBlueOneGap == 6){			
			//Cases: 6 blue, 3 pink, 0 cyan.  6 blue, 2 pink, 1 cyan.
			//If 3 pink one gaps and they are all in a row, reject.
			//If 2 pink one gaps and cyan in the correct position, flip it to blue.			
			for(int firstPoint = 0; firstPoint<guards.length; firstPoint++){				
				int secondPoint = (firstPoint+1)%guards.length;
				int thirdPoint = (firstPoint+2)%guards.length;
				int fourthPoint = (firstPoint+3)%guards.length;
				
				computeGuardPair(firstPoint,secondPoint,pair);
				String firstToSecond = edgeColor.get(pair);
				
				computeGuardPair(thirdPoint,secondPoint,pair);
				String secondToThird = edgeColor.get(pair);
				
				computeGuardPair(thirdPoint,fourthPoint,pair);
				String thirdToFourth = edgeColor.get(pair);
				
				if(!cannotBlock(firstToSecond) && !cannotBlock(secondToThird) && !cannotBlock(thirdToFourth)){					
					if(numPinkOneGap == 3){
						return 0;
					}else{						
						//2 pinks, 1 cyan in a row -> cyan flips to blue.
						computeGuardPair(oneGapToFlip1,oneGapToFlip2,pair);
						updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
					}
				}								
			}			
		}
		else if(numBlueOneGap == 5 && numCyanOneGap == 1){			
			//If 3 consecutive pink one-gap, flip cyan to pink.
			for(int firstPoint = 0; firstPoint<guards.length; firstPoint++){
				
				int secondPoint = (firstPoint+1)%guards.length;
				int thirdPoint = (firstPoint+2)%guards.length;
				int fourthPoint = (firstPoint+3)%guards.length;
				
				computeGuardPair(firstPoint,secondPoint,pair);
				String firstToSecond = edgeColor.get(pair);
				
				computeGuardPair(thirdPoint,secondPoint,pair);
				String secondToThird = edgeColor.get(pair);
				
				computeGuardPair(thirdPoint,fourthPoint,pair);
				String thirdToFourth = edgeColor.get(pair);
				
				if(mustBlock(firstToSecond) && mustBlock(secondToThird) && mustBlock(thirdToFourth)){					
					computeGuardPair(oneGapToFlip1,oneGapToFlip2,pair);
					updatedAnEdge = makeEdgeBlocked(edgeColor,pair) || updatedAnEdge;					
				}								
			}
		}
		
		if(updatedAnEdge){
			return 1;
		}else{
			return 2;
		}
	}				
	
	public static int boxChecker(int gap1, int gap2, int gap3, HashMap<ArrayList<String>,String> edgeColor){		
		//return 0 if we can reject it, return 1 if we cannot reject and flipped an edge, return 2 ow.
		String[] guards = {"A","B","C", "D", "E", "F", "G", "H", "I"};		
		ArrayList<String> pair = new ArrayList<String>();		
		boolean updatedAnEdge = false;
		
		for(int topLeft = 0; topLeft < guards.length; topLeft++){			
			int bottomLeft = (topLeft+gap1+1)%guards.length;
			int bottomRight = (bottomLeft+gap2+1)%guards.length;
			int topRight = (bottomRight+gap3+1)%guards.length;			
			int firstBlueGuard = -1;
			int secondBlueGuard = -1;			
			int weirdBoxRedEdges = 0;
			
			computeGuardPair(topLeft,bottomLeft,pair);
			if(edgeColor.get(pair).equalsIgnoreCase("red")){				
				weirdBoxRedEdges++;
			}
			else{
				firstBlueGuard = topLeft;
				secondBlueGuard = bottomLeft;
			}
			
			computeGuardPair(bottomRight,bottomLeft,pair);
			if(edgeColor.get(pair).equalsIgnoreCase("red")){				
				weirdBoxRedEdges++;
			}
			else{
				firstBlueGuard = bottomRight;
				secondBlueGuard = bottomLeft;
			}
			
			computeGuardPair(bottomRight,topRight,pair);
			if(edgeColor.get(pair).equalsIgnoreCase("red")){				
				weirdBoxRedEdges++;
			}
			else{
				firstBlueGuard = bottomRight;
				secondBlueGuard = topRight;
			}
			
			computeGuardPair(topLeft,topRight,pair);
			if(edgeColor.get(pair).equalsIgnoreCase("red")){				
				weirdBoxRedEdges++;
			}
			else{
				firstBlueGuard = topLeft;
				secondBlueGuard = topRight;
			}
			
			if(weirdBoxRedEdges < 3){
				continue;
			}
			
			
			if(weirdBoxRedEdges == 4){				
				return 0;
			}
			else if(weirdBoxRedEdges == 3){				
				computeGuardPair(firstBlueGuard,secondBlueGuard,pair);
				updatedAnEdge = makeEdgeNotBlocked(edgeColor,pair) || updatedAnEdge;
			}
			
		}
		
		if(updatedAnEdge){
			return 1;
		}		
		return 2;		
	}
	
	public static boolean makeEdgeNotBlocked(HashMap<ArrayList<String>,String> edgeColor, ArrayList<String> pair){		
		String theEdge = edgeColor.get(pair);
		if(theEdge.equalsIgnoreCase("cyan")){						
			edgeColor.replace(pair,"blue");
			return true;
		}
		else if(theEdge.equalsIgnoreCase("orange") || theEdge.equalsIgnoreCase("plum")){			
			edgeColor.replace(pair,"purple");
			return true;
		}
		else if(theEdge.equalsIgnoreCase("yellow")){			
			edgeColor.replace(pair,"green");
			return true;
		}		
		return false;
	}
	
	public static boolean makeEdgeBlocked(HashMap<ArrayList<String>,String> edgeColor, ArrayList<String> pair){		
		String theEdge = edgeColor.get(pair);
		if(theEdge.equalsIgnoreCase("orange") || theEdge.equalsIgnoreCase("cyan")){					
			edgeColor.replace(pair,"pink");
			return true;
		}
		else if(theEdge.equalsIgnoreCase("plum")){						
			edgeColor.replace(pair,"brown");
			return true;
		}
		else if(theEdge.equalsIgnoreCase("yellow")){						
			edgeColor.replace(pair,"red");
			return true;
		}		
		return false;
	}
	
	public static boolean makeEdgeClose(HashMap<ArrayList<String>,String> edgeColor, ArrayList<String> pair){		
		String theEdge = edgeColor.get(pair);
		if(theEdge.equalsIgnoreCase("cyan")){			
			edgeColor.replace(pair,"yellow");
			return true;
		}
		else if(theEdge.equalsIgnoreCase("blue")){			
			edgeColor.replace(pair,"green");
			return true;
		}
		else if(theEdge.equalsIgnoreCase("orange") || theEdge.equalsIgnoreCase("pink")){			
			edgeColor.replace(pair,"red");
			return true;
		}		
		return false;
	}
	
	public static boolean makeEdgeNotVisible(HashMap<ArrayList<String>,String> edgeColor, ArrayList<String> pair){		
		String theEdge = edgeColor.get(pair);
		if(theEdge.equalsIgnoreCase("cyan")){			
			edgeColor.replace(pair,"orange");
			return true;
		}
		else if(theEdge.equalsIgnoreCase("blue")){			
			edgeColor.replace(pair,"purple");
			return true;
		}
		else if(theEdge.equalsIgnoreCase("yellow")){			
			edgeColor.replace(pair,"red");
			return true;
		}		
		return false;
	}
	
	public static boolean cannotSee(String color){		
		return color.equalsIgnoreCase("orange") || mustBeFar(color) || mustBlock(color);
	}
	
	public static boolean mustBeClose(String color){		
		return color.equalsIgnoreCase("green") || color.equalsIgnoreCase("yellow") || color.equalsIgnoreCase("red");
	}
	
	public static boolean mustBeFar(String color){		
		return color.equalsIgnoreCase("purple") || color.equalsIgnoreCase("brown") || color.equalsIgnoreCase("plum");
	}
	
	public static boolean cannotBlock(String color){		
		return color.equalsIgnoreCase("green") || color.equalsIgnoreCase("blue") || color.equalsIgnoreCase("purple");
	}
	
	public static boolean mustBlock(String color){		
		return color.equalsIgnoreCase("red") || color.equalsIgnoreCase("brown") || color.equalsIgnoreCase("pink");
	}		
	
	public static ArrayList<String> initializeGapsThatWork(ArrayList<String> ordering, HashMap<ArrayList<String>, String> edgeColor, ArrayList<String> importantPoints, ArrayList<String> usableViewpoints){				
		int bigThreshold = 9000;				
		
		for(int i=0; i<usableViewpoints.size(); i++){			
			String thisPoint = usableViewpoints.get(i);
			ArrayList<String> gapsForThisPoint = new ArrayList<String>();
			Stack<ArrayList<String>> stackForThisPoint = new Stack<ArrayList<String>>();
			
			String prevPoint = "-infty";
			
			for (int j = 0; j < ordering.size(); ++j){				
				String currentPoint = ordering.get(j);				
				HashMap<ArrayList<String>, String> copyOfEdgeColors = new HashMap<ArrayList<String>, String>(edgeColor);
				ArrayList<String> newOrdering = new ArrayList<String>();
				newOrdering.clear();
				newOrdering.addAll(ordering);
				newOrdering.add(j, usableViewpoints.get(i));
				
				for(int k=0; k<newOrdering.size(); k++){
					if(k==j){
						continue;
					}
					
					ArrayList<String> pair = new ArrayList<String>();
					computePair(k,j,pair,newOrdering);
					String otherPoint = newOrdering.get(k);
					
					if(otherPoint.length() > 1){						
						//VP-VP edge
						copyOfEdgeColors.put(pair,"cyan");
					}
					else if(thisPoint.indexOf(otherPoint) == -1){						
						//VP-Guard that don't see each other
						copyOfEdgeColors.put(pair,"orange");				
					}
					else{
						//VP-Guard that see each other
						copyOfEdgeColors.put(pair,"green");
					}
				}
				
				if (isFeasibleOrdering(newOrdering,copyOfEdgeColors,false)){					
					gapsForThisPoint.add(prevPoint + ":" + currentPoint);										
					if(gapsForThisPoint.size() > bigThreshold && !importantPoints.contains(thisPoint)){
						break;
					}
				}				
				prevPoint = currentPoint;
			}									
			if(gapsForThisPoint.size() == 0){
				printToOutputFile("No gaps for " + thisPoint + ".  Rejecting.");
				for(int z =0; z<i; z++){
					String oldPoint = usableViewpoints.get(z);
					String hashKey = oldPoint;
					gapsThatWork.get(hashKey).pop();
				}
				
				return null; //null means we are rejecting.
			}
			
			if(gapsForThisPoint.size() > bigThreshold  && !importantPoints.contains(thisPoint)){
				gapsForThisPoint = new ArrayList<String>();
				gapsForThisPoint.add("Big");
				gapsForThisPoint.add("ManyViewpoints");
			}
			
			stackForThisPoint.push(gapsForThisPoint);
			String hashKey = thisPoint;
			gapsThatWork.put(hashKey,stackForThisPoint);			
		}		
		return ordering;		
	}			
	
	public static boolean checkIfPointWithNoGaps(ArrayList<String> ordering, HashMap<ArrayList<String>, String> edgeColor){		
		viewPointLoop:
		for(int i=0; i<listOfAllViewpoints.size(); i++){			
			String thisPoint = listOfAllViewpoints.get(i);						
			boolean foundAGap = false;
			
			for (int j = 0; j < ordering.size(); ++j){				
				HashMap<ArrayList<String>, String> copyOfEdgeColors = new HashMap<ArrayList<String>, String>(edgeColor);								
				ArrayList<String> newOrdering = new ArrayList<String>();
				newOrdering.addAll(ordering);
				newOrdering.add(j, listOfAllViewpoints.get(i));
				
				for(int k=0; k<newOrdering.size(); k++)	{
					if(k==j){
						continue;
					}
					
					ArrayList<String> pair = new ArrayList<String>();
					computePair(k,j,pair,newOrdering);
					String otherPoint = newOrdering.get(k);
					
					if(otherPoint.length() > 1){						
						//VP-VP edge
						copyOfEdgeColors.put(pair,"cyan");
					}
					else if(thisPoint.indexOf(otherPoint) == -1){						
						//VP-Guard that don't see each other
						copyOfEdgeColors.put(pair,"orange");				
					}
					else{
						//VP-Guard that see each other
						copyOfEdgeColors.put(pair,"green");
					}
				}
				
				if (isFeasibleOrdering(newOrdering,copyOfEdgeColors,false)){
					foundAGap = true;
					continue viewPointLoop;
				}				
			}
			
			if(!foundAGap){
				printToOutputFile("No gaps for " + thisPoint + ".  Rejecting.");				
				return true;  //null means we are rejecting.
			}			
		}		
		return false;		
	}
	
	public static void printToOutputFile(String currentLine){
		System.out.println(currentLine);
		totalLinesInCurrentOutuputFile++;
		outputTemporaryText.add(currentLine);
		//Print every 30 minutes or so, every ~300 lines of output.
		if(outputTemporaryText.size()>=300 || currentLine.contains("rejected")){
			try{
				PrintWriter fout = new PrintWriter(new FileWriter(outputFileName+"-part"+currentOutputFileNumber+".txt", true));
				for(String currentText : outputTemporaryText){
					fout.println(currentText);
				}
				fout.close();
				outputTemporaryText.clear();
			} catch(Exception e){
				System.out.println("Error occurred.");
				e.printStackTrace();
				System.exit(0);
			}
			//If output file is roughly 5MB in size, stop printing to it, start a new output file. Done because of quota issues.
			if(totalLinesInCurrentOutuputFile>=9000){
				currentOutputFileNumber++;
				totalLinesInCurrentOutuputFile = 0;
			}
		}        
	}
	
	public static class RunIt extends Thread {
		
		public void run() {
			try {			
				//Ordering is usually retrieved from a file. Hardcoded here for an example.
				String orderingFromFile = "A,B,C,D,E,ACEGH,F,G,BDFH,H,I";	

				String[] arr = orderingFromFile.split(",");
				ArrayList<String> ordering = new ArrayList<String>();
				for (String item : arr) {
					ordering.add(item);
				}
				
				boolean rejected = false;				
				
				if(!isFeasibleOrdering(ordering,null,true)){
					rejected = true;
				}
				
				ArrayList<String> pointsWeAreUsing = new ArrayList<String>();
				for(String s : allViewpointsConsideredForCurrentCase){
					pointsWeAreUsing.add(s);
				}
				
				listOfAllViewpoints = new ArrayList<String>();
				for(String s : allOfTheViewpoints){
					listOfAllViewpoints.add(s);
				}
				
				listOfAllViewpoints.removeAll(pointsWeAreUsing);
				listOfAllViewpoints.removeAll(ordering);
				
				if(!rejected){                        					
					long startTime = System.currentTimeMillis();
					String result = determineCase(ordering);
					long endTime = System.currentTimeMillis();					
					long runningTime = (endTime - startTime)/1000;					
					if(!result.equals("")){
						printToOutputFile("Case accepted in " + runningTime + " seconds. \n" + result);					
					} else{						
						printToOutputFile("Case rejected in " + runningTime + " seconds (which is what we want).");						
					}
				} else{
					//reject case
					printToOutputFile("Case rejected immediately - initial case is infeasible.");
				}											
			} catch (Exception e) {
				printToOutputFile("Got an exception: " + e);
				e.printStackTrace();
			}
		}
	}
}