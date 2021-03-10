package com.feylabs.codelab_one.Data

import com.feylabs.codelab_one.Model.BookModel
import com.feylabs.codelab_one.R

object BookDataSource {

    val image = listOf(
        R.drawable.book_atomic_habits,
        R.drawable.book_earth_of_mankind,
        R.drawable.unspeakable,
        R.drawable.book_5_towers,
        R.drawable.book_joy_of_work,
        R.drawable.book_being_had,
        R.drawable.book_vesper,
        R.drawable.book_minor_feeling,
        R.drawable.book_tkmb,
        R.drawable.book_hobbit

    )

    val author = listOf(
        "James Clear",
        "P.A. Toer",
        "Jess Lourey",
        "Ahmad Fuadi",
        "Marie Kondo",
        "Eula Biss",
        "Helen Macdonald",
        "Cathy Park",
        "Harper Lee",
        "J.R.R. Tolkien"
    )

    val title = listOf<String>(
        "Atomic Habit",
        "Earth Of Mankind",
        "Unspeakable Things",
        "Land Of Five Towers",
        "Joy at Work",
        "Having and Being Had",
        "Vesper Flights",
        "Minor Feelings",
        "To Kill a Mockingbird",
        "The Hobbit"
    )

    val desc = listOf(
        //1
        "No matter your goals, Atomic Habits offers a proven framework for improving--every day. James Clear, one of the world's leading experts on habit formation, reveals practical strategies that will teach you exactly how to form good habits, break bad ones, and master the tiny behaviors that lead to remarkable results.\n" +
                "\n" +
                "If you're having trouble changing your habits, the problem isn't you. The problem is your system. Bad habits repeat themselves again and again not because you don't want to change, but because you have the wrong system for change. You do not rise to the level of your goals. You fall to the level of your systems. Here, you'll get a proven system that can take you to new heights.\n" +
                "\n" +
                "Clear is known for his ability to distill complex topics into simple behaviors that can be easily applied to daily life and work. Here, he draws on the most proven ideas from biology, psychology, and neuroscience to create an easy-to-understand guide for making good habits inevitable and bad habits impossible. Along the way, readers will be inspired and entertained with true stories from Olympic gold medalists, award-winning artists, business leaders, life-saving physicians, and star comedians who have used the science of small habits to master their craft and vault to the top of their field.\n" +
                "\n" +
                "Learn how to:\n" +
                "  •  make time for new habits (even when life gets crazy);\n" +
                "  •  overcome a lack of motivation and willpower;\n" +
                "  •  design your environment to make success easier;\n" +
                "  •  get back on track when you fall off course;\n" +
                "...and much more.\n" +
                "\n" +
                "Atomic Habits will reshape the way you think about progress and success, and give you the tools and strategies you need to transform your habits--whether you are a team looking to win a championship, an organization hoping to redefine an industry, or simply an individual who wishes to quit smoking, lose weight, reduce stress, or achieve any other goal."
        //2
        ,
        "This Earth of Mankind is the first book in Pramoedya Ananta Toer's epic quartet called Buru Quartet, first published by Hasta Mitra in 1980. The story is set at the end of the Dutch colonial rule and was written while Pramoedya was imprisoned on the political island prison of Buru in eastern Indonesia. The story was first narrated verbally to Pramoedya's fellow prisoners in 1973 because he did not get permission to write.[1] The story spread through all the inmates until 1975 when Pramoedya was finally granted permission to write the detailed story."
        //3
        ,
        "Cassie McDowell’s life in 1980s Minnesota seems perfectly wholesome. She lives on a farm, loves school, and has a crush on the nicest boy in class. Yes, there are her parents’ strange parties and their parade of deviant guests, but she’s grown accustomed to them.\n" +
                "\n" +
                "All that changes when someone comes hunting in Lilydale.\n" +
                "\n" +
                "One by one, local boys go missing. One by one, they return changed—violent, moody, and withdrawn. What happened to them becomes the stuff of shocking rumors. The accusations of who’s responsible grow just as wild, and dangerous town secrets start to surface. Then Cassie’s own sister undergoes the dark change. If she is to survive, Cassie must find her way in an adult world where every sin is justified, and only the truth is unforgivable."
        //4
        ,
        "a novel inspired by a true story (English Edition) Synopsis: Alif had never set foot outside of West Sumatra. He passed his childhood days searching for fallen durian fruit in the jungle, playing soccer on rice paddies, and swimming in the blue waters of Lake Maninjau. His mother wants him to attend an Islamic boarding school, a pesantren, while he dreams of public high school. Halfheartedly, he follows his mother’s wishes. He finds himself on a grueling three-day bus ride from Sumatra to Madani Pesantren (MP) in a remote village on Java. On his first day at MP, Alif is captivated by the powerful phrase man jadda wajada. He who gives his all will surely succeed. United by punishment, he quickly becomes friends with five boys from across the archipelago, and together they become known as the Fellowship of the Manara. Beneath the mosque’s minaret, the boys gaze at the clouds on the horizon, seeing in them their individual dreams of far-away lands, like America and Europe. Where would these dreams take them? They didn’t know. What they did know was: never underestimate dreams, no matter how high they may be. God truly is The Listener."
        //5
        ,
        "The workplace is a magnet for clutter and mess. Who hasn't felt drained by wasteful meetings, disorganized papers, endless emails, and unnecessary tasks? These are the modern-day hazards of working, and they can slowly drain the joy from work, limit our chances of career progress, and undermine our well-being"
        //6
        ,
        "In Having and Being Had, her collection of snappy essays concerned with capitalism and privilege, Eula Biss addresses the discomforts that come with living comfortably. At the start of the book, she and her husband have just purchased their first house, leading her to question the actual value she assigns to the items she’s considering buying. Biss investigates everything from the messaging on IKEA catalogs (which, she discovers, creepily suggest that “consumers” and “people” are not one and the same) to the origins of Monopoly, constantly evaluating the purpose these items serve in our lives. Through her precise and poetic prose, Biss makes startling observations on the inner-workings of capitalism and how it informs our perspectives on class and property"
        //7
        ,
        "When the world stopped this year, many people found themselves looking out the window, hearing birdsong replace car horns and watching green buds emerge from the frozen ground. In a moment of darkness, it was a wonderful balm to turn to nature. And in her beautiful collection of essays, Vesper Flights, Helen Macdonald shows us how to better observe and comprehend the scenes around us and to enter, however briefly, the worlds of other living things, whether starlings overhead or mushrooms at our feet. In exquisite prose, Vesper Flights further establishes Macdonald as one of the great nature writers of our time—and as a ringing voice of sorrow against the ravages of climate change. Read her to be enthralled, and read her as warning."
        //8
        ,
        "Poet and essayist Cathy Park Hong blends memoir, cultural criticism, and history to expose the truth of racialized consciousness in America. Binding these essays together is Hong's theory of \"minor feelings.\" As the daughter of Korean immigrants, Cathy Park Hong grew up steeped in shame, suspicion, and melancholy. She would later understand that these \"minor feelings\" occur when American optimism contradicts your own reality—when you believe the lies you're told about your own racial identity."
        //9
        ,
        "Published in 1960, this timeless classic explores human behaviour and the collective conscience of The Deep South in the early 20th century. Humour entwines the delicate strands of prejudice, hatred, hypocrisy, love and innocence to create one of the best novels ever written."
        //10
        ,
        "The story is told in the form of an episodic quest, and most chapters introduce a specific creature or type of creature of Tolkien's geography. Bilbo gains a new level of maturity, competence, and wisdom by accepting the disreputable, romantic, fey, and adventurous sides of his nature and applying his wits and common sense. The story reaches its climax in the Battle of Five Armies, where many of the characters and creatures from earlier chapters re-emerge to engage in conflict."
    )

    val bookData: MutableList<BookModel>
        get() {
            val tempList = mutableListOf<BookModel>()
            for (position in desc.indices) {
                val bookModel = BookModel()
                bookModel.title = title[position]
                bookModel.author = author[position]
                bookModel.desc = desc[position]
                bookModel.image = image[position]
                tempList.add(bookModel)
            }
            return tempList
        }

}

