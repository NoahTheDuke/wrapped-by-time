(ns noahtheduke.album-mbid-override)

(defn normalize-artist [artist]
  (case artist
    "Matthew S Burns" "Matthew S. Burns"
    ; else
    artist))

(def artist->albums->mbid
  {

   "2 Mello"
   {#{"PHD: Portable Headphone Dancefloor"
      "PHD - PORTABLE HEADPHONE DANCEFLOOR"}
    {:normalized-album "PHD: Portable Headphone Dancefloor"
     :album-mbid "5382aab0-0ac8-4b32-a3bf-8f34bd29732b"}
    #{"Sounds of Tokyo-To Future"
      "Sounds Of Tokyo-To Future"}
    {:normalized-album "Sounds of Tokyo-To Future"
     :album-mbid "16e64406-24fe-4ffe-8960-9608561ab9fa"}}

   "Bell Witch"
   {#{"Four Phantoms"}
    {:album-mbid "de2dd6d1-96e8-4cf9-8f1f-86bf364142d6"}
    #{"Future's Shadow Part 1: The Clandestine Gate"
      "Future's Shadow, Part 1: The Clandestine Gate"}
    {:normalized-album "Future's Shadow, Part 1: The Clandestine Gate"
     :album-mbid "b74af046-c2fc-4e80-b6dc-a7fe9b83ffc3"}
    #{"Mirror Reaper"}
    {:album-mbid "5a69dd22-6431-40ea-8a2e-b52b3973a60f"}}

   "Ben Prunty"
   {#{"Into the Breach Soundtrack"}
    {:album-mbid "fc4b50f2-7f31-4d36-95a6-91ec2cb2d685"}
    #{"Into the Breach Advanced Edition Soundtrack"}
    {:album-mbid "1516fb5b-ed2a-4559-a762-b4d9ccd6804f"}}

   "Blind Guardian"
   {#{"The God Machine"}
    {:album-mbid "a411424b-a202-4a57-b1ee-eeb62a1d5b41"}}

   "Cave-In"
   {#{"Heavy Pendulumn"}
    {:album-mbid "c3865379-e5cc-4343-b888-bfc6a9b5f519"}}

   "Chipzel"
   {#{"Chipped of the Necrodancer"}
    {:album-mbid "a824b449-67cf-497b-9eb6-6d00078a49d2"}
    #{"Dicey Dungeons"}
    {:album-mbid "c5ec6d32-0ae3-4156-9fd0-1b8e31e7f5c7"}
    #{"Dicey Dungeons: Reunion"}
    {:album-mbid "a3865db7-7e15-4a95-8bb6-c40c82886038"}}

   "Conan"
   {#{"Evidence of Immortality" "Evidence Of Immortality"}
    {:normalized-album "Evidence of Immortality"
     :album-mbid "e60be455-1d4f-44f8-ab80-e031d84c41aa"}}

   "Critical Defiance"
   {#{"No Life Forms"}
    {:album-mbid "f08b05fd-2677-486d-bbe9-b4d893237e48"}}

   "Danny Baranowsky"
   {#{"Crypt of the Necrodancer Original Soundtrack"
      "Crypt of the Necrodancer (Original Game Soundtrack)"}
    {:normalized-album "Crypt of the Necrodancer Original Soundtrack"
     :album-mbid "c0d36ec3-1639-478a-ad39-6cded1e72887"}
    #{"Crypt of the Necrodancer Amplified (Original Game Soundtrack)"}
    {:album-mbid "5d0f8221-6918-4d8e-8652-22d0275ac684"}}

   "Enforced"
   {#{"At The Walls"}
    {:album-mbid "aca2fa8a-c4bf-4c41-87e6-5fc7977f1a6b"}
    #{"Kill Grid"}
    {:album-mbid "15a1aeab-e342-4e02-85b8-54e265f66a56"}
    #{"Hanged by My Hand" "Ultra-Violence" "War Remains"}
    {:normalized-album "War Remains"
     :album-mbid "df63208c-4393-4f37-a288-a136ea2a233e"}}

   "Enforcer"
   {#{"Coming Alive"}
    {:album-mbid "6426df65-c9ad-4653-9040-4686cee9f5c7"}}

   "FamilyJules"
   {#{"Aria Amplified"}
    {:album-mbid "5f69c410-31f0-408f-8a8b-75c6ab8af2c2"}
    #{"Aria's Ascent (The Crypt of the Necrodancer Metal Soundtrack)"}
    {:normalized-album "Aria's Ascent"
     :album-mbid "b59d5a4e-0638-4f79-9aa4-9f6588c3cf8e"}
    #{"Aria Awakened"}
    {:album-mbid "e7baea21-5cf4-4390-b223-12e4cb1e1142"}}

   "Grahm Nesbitt"
   {#{"Floppy Knights Original Soundtrack"
      "Floppy Knights (Original Soundtrack)"}
    {:normalized-album "Floppy Knights Original Soundtrack"
     :album-mbid "2eb45d78-9b6c-4a0c-bd2b-d8bf2edd1487"}}

   "Grails"
   {#{"Anches En Maat"}
    {:album-mbid "b3205ee7-e8fc-465f-bea5-81c7f079dedf"}}

   "Hirokazu Ando"
   {#{"Kirby and the Forgotten Land Original Soundtrack"
      "Kirby and the Forgotten Land Original Soundtrack (Loop)"}
    {:normalized-album "Kirby and the Forgotten Land Original Soundtrack"
     :album-mbid "2b2550b3-454c-474a-b35c-87c393f39193"}}

   "Hot Chip"
   {#{"A Bath Full of Ecstasy"}
    {:album-mbid "8d1bb07c-1556-47c5-af89-4dcaa9184763"}}

   "Immortal Bird"
   {#{"Empress/Abscess"
      "Empress / Abscess"}
    {:normalized-album "Empress / Abscess"
     :album-mbid "6c0f85e9-719d-43a7-ad85-e30c3a393719"}
    #{"Thrive on Neglect"}
    {:album-mbid "9aad0e30-1487-4310-8f6b-8f9b4888658f"}}

   "Incendiary"
   {#{"Bite the Hook"}
    {:album-mbid "6722be10-b05b-42ac-abbc-65d6d2764364"}
    #{"Thousand Mile Stare"}
    {:album-mbid "911f01bc-8bdf-4b01-99c1-94920605e284"}}

   "JAY-Z"
   {#{"The Black Album"}
    {:album-mbid "dcb09143-f938-3381-bd4e-94034cc40d34"}}

   "King Gizzard & The Lizard Wizard"
   {#{"Butterfly 3000"}
    {:album-mbid "99517c21-0583-45c5-96e6-b90575090e45"}
    #{"Changes"}
    {:album-mbid "3fe553cd-5e38-4b55-8052-656821f6d113"}
    #{"Fishing for Fishies"}
    {:album-mbid "8e991d1c-fde3-45f2-b3ab-5af96648a720"}
    #{"Flying Microtonal Banana"}
    {:album-mbid "52e98ea4-25c0-47f9-9cef-256aa7c82d32"}
    #{"Gumboot Soup"}
    {:album-mbid "bf89e0e1-a5de-4afe-8ce3-b4ccf2b98bb7"}
    #{"Ice, Death, Planets, Lungs, Mushrooms and Lava"}
    {:album-mbid "effb54cb-a335-4556-8e43-7663c310c43b"}
    #{"I'm in Your Mind Fuzz" "I'm In Your Mind Fuzz"}
    {:normalized-album "I'm in Your Mind Fuzz"
     :album-mbid "c4f78d96-c742-4a01-9fb0-e6456161c7f7"}
    #{"K.G."}
    {:album-mbid "48acfcf1-8114-44a9-b45b-f828a8fcce87"}
    #{"L.W."}
    {:album-mbid "61c386be-c0b0-41f8-8290-aede50a046b0"}
    #{"Laminated Denim"}
    {:album-mbid "536e0285-317d-412c-b2aa-b71b732d13d7"}
    #{"Murder of the Universe"}
    {:album-mbid "111fff89-ed9f-4a1e-bdfc-18cdd94d0eb9"}
    #{"Nonagon Infinity"}
    {:album-mbid "dc0b280c-63bb-4bd5-9e7b-b91363cb1ea3"}
    #{"Omnium Gatherum"}
    {:album-mbid "90de8283-f155-45e7-928b-b1dd22d35a84"}
    #{"Paper Mâché Dream Balloon"}
    {:album-mbid "5b5bc425-d2d2-4c03-b186-7fd4349b7541"}
    #{"PetroDragonic Apocalypse; or, Dawn of Eternal Night: An Annihilation of Planet Earth and the Beginning of Merciless Damnation"}
    {:album-mbid "ffa01757-13ca-404d-8812-b5a07793d55b"}
    #{"Polygondwanaland"}
    {:album-mbid "c31fb788-69b2-4e80-8612-ef24f61edd57"}
    #{"Quarters!"}
    {:album-mbid "db7bcea2-245e-47b5-b484-79b2d89c9c20"}
    #{"Sketches of Brunswick East"}
    {:album-mbid "10e44a3d-fa3f-41bf-91b6-0049b227d119"}}

   "Leggy"
   {#{"Dramatica"}
    {:album-mbid "fec765b4-f341-4f14-8443-d16833cfb096"}}

   "Lena Raine"
   {#{"Celeste Original Soundtrack"}
    {:album-mbid "e07b0b17-bde9-4677-ac07-ba390d63d4c5"}}

   "M. M. Keeravani"
   {#{"RRR"
      "Dosti (From \"RRR\")"
      "Etthara Jenda (From \"RRR\")"
      "Janani (From \"Rrr\")"
      "Komuram Bheemudo (From \"RRR\")"
      "Naatu Naatu (From \"Rrr\")"
      "Raamam Raaghavam (From \"Rrr\")"}
    {:normalized-album "RRR"
     :album-mbid "07614c20-570d-45ee-8829-72c5ac2dd6a1"}
    #{"Rrr Ost Vol-1"}
    {:normalized-album "RRR"
     :album-mbid "8253e132-01a1-4c20-8ae2-1c8ce431c36e"}
    #{"Rrr Ost Vol-2"}
    {:normalized-album "RRR"
     :album-mbid "efbe37aa-873b-4525-a49d-23bcb7c92be3"}
    #{"Rrr Ost Vol-3"}
    {:normalized-album "RRR"
     :album-mbid "a736e0b5-0561-49d6-869d-83df98be35e2"}
    #{"Rrr Ost Vol-4"}
    {:normalized-album "RRR"
     :album-mbid "7eea5380-3d3d-4e1e-99a2-17ef42cfbff3"}
    #{"Rrr Ost Vol-7"}
    {:normalized-album "RRR"
     :album-mbid "d56b1890-d951-4bfb-b014-32df433f4c02"}}

   "Machine Girl"
   {#{"Neon White Original Soundtrack"
      "Neon White Soundtrack Part 1 “The Wicked Heart”"
      "Neon White Soundtrack Part 1 \"The Wicked Heart\""
      "Neon White Soundtrack Part 2 “The Burn That Cures”"
      "Neon White Soundtrack Part 2 \"The Burn That Cures\""}
    {:normalized-album "Neon White Original Soundtrack"
     :album-mbid "6ff7c666-0b38-4c5d-8d04-5abbb59d0d96"}}

   "Maharaja"
   {#{"Aviarium"}
    {:album-mbid "d7a2f54d-f6a6-4be5-a352-a933b103f868"}
    #{"Kali Yuga"}
    {:album-mbid "399b0e9e-cc63-4d91-bac9-b23be38d3bb4"}}

    "Majesties"
    {#{"Vast Reaches Unclaimed" "The World Unseen"}
     {:normalized-album "Vast Reaches Unclaimed"
      :album-mbid "bec50db3-cc38-46b7-9821-12798f39a1fc"}}

   "Mares of Thrace"
   {#{"The Exile"}
    {:album-mbid "0ca14f1f-4377-4979-af96-086e6f85f632"}}

   "Matthew S. Burns"
   {#{"Eliza Original Soundtrack" "Eliza (Original Soundtrack)"}
    {:normalized-album "Eliza Original Soundtrack"
     :album-mbid "a3673d2f-e7e6-49c0-934f-d57cd8917286"}
    #{"Exapunks Original Soundtrack" "Exapunks (Original Soundtrack)"
      "EXAPUNKS Original Soundtrack" "EXAPUNKS (Original Soundtrack)"}
    {:normalized-album "EXAPUNKS Original Soundtrack"
     :album-mbid "91f71eb5-b814-4c1c-93f4-f9f414b19062"}
    #{"Fortune's Foundation" "Fortune's Foundation (Original Soundtrack)"}
    {:normalized-album "Fortune's Foundation Original Soundtrack"
     :album-mbid "c1a0384d-2869-40fc-b098-8d713faf9f30"}
    #{"Infinifactory: The Original Video Game Soundtrack"}
    {:album-mbid "a8c6bebc-d097-42fb-9a15-08a650cbc692"}
    #{"Last Call BBS" "Last Call BBS (Original Soundtrack)"}
    {:normalized-album "Last Call BBS Original Soundtrack"
     :album-mbid "ad59e526-f053-4954-aefd-f25ad830182a"}
    #{"MOLEK-SYNTEZ"}
    {:album-mbid "6fb03c56-247b-450c-9559-0857e29f9ce4"}
    #{"Möbius Front '83" "Möbius Front '83 (Original Soundtrack)"}
    {:normalized-album "Möbius Front '83 Original Soundtrack"
     :album-mbid "76ff0dfd-ae0e-46c3-bb43-3d5abd159fd6"}
    #{"Opus Magnum Original Soundtrack" "Opus Magnum (Original Soundtrack)"}
    {:normalized-album "Opus Magnum Original Soundtrack"
     :album-mbid "35cf6285-c58f-430e-9f06-53db35724252"}
    #{"Shenzhen I/O" "Shenzhen I/O (Original Soundtrack)"
      "SHENZHEN I/O" "SHENZHEN I/O (Original Soundtrack)"}
    {:normalized-album "Shenzhen I/O Original Soundtrack"
     :album-mbid "e896d998-9d97-4f56-bf34-2d607bcc3d42"}}

   "Megaton Sword"
   {#{"Might & Power"}
    {:album-mbid "7b81e19b-9367-49bb-91d4-f600ae8ea710"}
    #{"Blood Hails Steel - Steel Hails Fire"}
    {:album-mbid "bb97e8d8-35a6-46fa-905f-c15c5c0a035c"}}

   "Nintendo"
   {#{"Kirby and the Forgotten Land Original Soundtrack"
      "Kirby and the Forgotten Land Original Soundtrack (Loop)"}
    {:normalized-album "Kirby and the Forgotten Land Original Soundtrack"
     :album-mbid "2b2550b3-454c-474a-b35c-87c393f39193"}}

   "Opeth"
   {#{"In Cauda Venenum"}
    {:album-mbid "10833cdd-55de-4515-b614-8decd842015f"}}

   "Pallbearer"
   {#{"Atlantis"}
    {:album-mbid "293df047-253f-473f-ace9-d291bd1f04aa"}
    #{"Fear and Fury"}
    {:album-mbid "35fb6f32-1676-41cb-8753-8c15cffec522"}
    #{"Forgotten Days"}
    {:album-mbid "253fee97-b588-4b3f-bf5a-e6186791be32"}
    #{"Foundations of Burden"}
    {:album-mbid "c0c10758-b725-45e0-926b-f71ce86c9ad7"}
    #{"Heartless"}
    {:album-mbid "2e5a1581-e8e4-4f59-8724-e9b498703843"}
    #{"Heartless - An Alternative Mix From Fellowship Hall Sound"}
    {:album-mbid "c529b0a7-2c3c-42a9-b33c-ff19b1616a68"}
    #{"Sorrow and Extinction"}
    {:album-mbid "2c713937-9363-4899-8b7d-1f148a91c5c2"}}

   "Raffi"
   {#{"Everything Grows"}
    {:album-mbid "87200fc1-543c-47b7-bee4-5447886daf41"}}

   "Ripped To Shreds"
   {#{"劇變 (Jubian)"}
    {:album-mbid "5a141dc3-e6d6-4cac-a964-2c38b1093f93"}}

   "Sabrina Carpenter"
   {#{"Short n' Sweet"}
    [:album-mbid "84190924-8e99-417e-9703-17b7722df4e7"]}

   "Spirit Adrift"
   {#{"Curse Of Conception"}
    {:album-mbid "08f77cd4-7285-428c-92ad-a963b7f7bf1d"}}

   "Taylor Swift"
   {
    #{"Taylor Swift"}
    {:album-mbid "337a2be7-cd50-438b-b955-b7423103803c"}
    #{"Fearless"
      "Fearless (Big Machine Radio Release Special)"}
    {:normalized-album "Fearless"
     :album-mbid "f06ea3d7-d7bb-4556-ab78-b57a9e799db3"}
    #{"Fearless (Taylor's Version)"}
    {:album-mbid "361a8f4e-e967-4fb7-8316-1394ba1adbcb"}
    #{"Speak Now" "Speak Now (Deluxe Package)"}
    {:normalized-album "Speak Now"
     :album-mbid "3c304ad1-7335-44d0-b59a-4e306d591666"}
    #{"Speak Now (Taylor's Version)"}
    {:album-mbid "cc3a3c56-a97e-434a-b84d-7431b5a392bb"}
    #{"Red" "Red (Deluxe Edition)"
      "All Too Well (Sad Girl Autumn Version) - Recorded at Long Pond Studios"}
    {:normalized-album "Red"
     :album-mbid "351368bd-aeb5-4913-b314-7f8c415e7e3f"}
    #{"Red (Taylor's Version)"}
    {:album-mbid "2d14b56f-ea1c-491f-80a2-794baff03b2c"}
    #{"1989"
      "1989 (Deluxe Edition)"}
    {:normalized-album "1989"
     :album-mbid "b0bf9042-2dbf-4215-a947-eda9ed2528b4"}
    #{"1989 (Taylor's Version)"
      "1989 (Taylor's version)"
      "1989 (Taylor's Version) (Deluxe)"}
    {:normalized-album "1989 (Taylor's Version)"
     :album-mbid "499b0b87-0c65-4382-a555-382db0a4aff5"}
    #{"reputation"}
    {:album-mbid "f72d1ca9-fe65-4399-b00d-6c4018d5bbd3"}
    #{"Christmas Tree Farm"}
    {:album-mbid "1f544bc0-0ab7-4da1-a69a-d26871c85a76"}
    #{"Lover"}
    {:album-mbid "b46cfd25-e697-44ed-ba55-4757fee620de"}
    #{"folklore" "folklore (deluxe version)"}
    {:normalized-album "folklore"
     :album-mbid "5a1f0de3-209e-40a8-9b04-2e1d876ebc3e"}
    #{"evermore" "evermore (deluxe version)"}
    {:normalized-album "evermore"
     :album-mbid "c1c8a25a-8289-49d2-82bf-5d870aa6be75"}
    #{"Midnights" "Midnights (3am Edition)"
      "Midnights (The Til Dawn Edition)"}
    {:normalized-album "Midnights"
     :album-mbid "00dd1688-8279-45a5-bdef-f0958c249014"}
    }

   "Wake"
   {#{"Thought Form Descent"}
    {:album-mbid "f9af082c-8e84-435a-9cee-3a7e812fb82b"}}

   "YOB"
   {#{"Atma" "Atma (Deluxe Edition)"}
    {:normalized-album "Atma"
     :album-mbid "c522a4d4-cd2f-494c-8040-4514f17fc84f"}
    #{"Catharsis"}
    {:album-mbid "caa5a42c-6776-4ae1-9231-82dad172ead0"}
    #{"Clearing the Path to Ascend"}
    {:album-mbid "b6abb840-e434-44f9-8050-5f1be40cc77e"}
    #{"Elaborations of Carbon"}
    {:album-mbid "1b4fe2ad-6dc1-44fd-90f7-635fd725e7c4"}
    #{"Our Raw Heart"}
    {:album-mbid "73892451-266b-45c7-ba7c-1bfb95328674"}
    #{"The Great Cessation"}
    {:album-mbid "00dfb06a-8d11-4e79-9f74-cf1050e2fdac"}
    #{"The Illusion of Motion"
      "The Illusion Of Motion"}
    {:normalized-album "The Illusion of Motion"
     :album-mbid "55cbacb7-0703-4923-b53f-78a164cda19b"}
    #{"The Unreal Never Lived"}
    {:album-mbid "c2ebbe67-933a-4d1b-993e-a54c4ea8b84b"}}

   })

(defn manual-album-mbid
  [{:keys [artist album album-mbid]}]
  (let [artist (normalize-artist artist)]
    (if-let [albums->mbid (artist->albums->mbid artist)]
      (reduce-kv
        (fn [_ albums override]
          (when (contains? albums album)
            (reduced override)))
        nil albums->mbid)
      album-mbid)))
