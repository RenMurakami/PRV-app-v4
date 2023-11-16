package profilerClass

import java.io.Serializable

class Profiler  {

    //This will be on the tile scene
    var name = ""
    // Number of profiler on the select scene
    // Minimum is 1, and Maxium is 6
    var numProf=1

    public var profilerList = mutableListOf<ProfType>()




}