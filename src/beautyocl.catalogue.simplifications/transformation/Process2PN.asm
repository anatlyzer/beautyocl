<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="Process2PN"/>
		<constant value="links"/>
		<constant value="NTransientLinkSet;"/>
		<constant value="col"/>
		<constant value="J"/>
		<constant value="main"/>
		<constant value="A"/>
		<constant value="OclParametrizedType"/>
		<constant value="#native"/>
		<constant value="Collection"/>
		<constant value="J.setName(S):V"/>
		<constant value="OclSimpleType"/>
		<constant value="OclAny"/>
		<constant value="J.setElementType(J):V"/>
		<constant value="TransientLinkSet"/>
		<constant value="A.__matcher__():V"/>
		<constant value="A.__exec__():V"/>
		<constant value="self"/>
		<constant value="__resolve__"/>
		<constant value="1"/>
		<constant value="J.oclIsKindOf(J):B"/>
		<constant value="18"/>
		<constant value="NTransientLinkSet;.getLinkBySourceElement(S):QNTransientLink;"/>
		<constant value="J.oclIsUndefined():B"/>
		<constant value="15"/>
		<constant value="NTransientLink;.getTargetFromSource(J):J"/>
		<constant value="17"/>
		<constant value="30"/>
		<constant value="Sequence"/>
		<constant value="2"/>
		<constant value="A.__resolve__(J):J"/>
		<constant value="QJ.including(J):QJ"/>
		<constant value="QJ.flatten():QJ"/>
		<constant value="e"/>
		<constant value="value"/>
		<constant value="resolveTemp"/>
		<constant value="S"/>
		<constant value="NTransientLink;.getNamedTargetFromSource(JS):J"/>
		<constant value="name"/>
		<constant value="__matcher__"/>
		<constant value="A.__matchProcess2Net():V"/>
		<constant value="A.__matchTask2Place():V"/>
		<constant value="A.__matchnext2Transition():V"/>
		<constant value="__exec__"/>
		<constant value="Process2Net"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyProcess2Net(NTransientLink;):V"/>
		<constant value="Task2Place"/>
		<constant value="A.__applyTask2Place(NTransientLink;):V"/>
		<constant value="next2Transition"/>
		<constant value="A.__applynext2Transition(NTransientLink;):V"/>
		<constant value="addTransitions"/>
		<constant value="Process"/>
		<constant value="J.allInstances():J"/>
		<constant value="J.first():J"/>
		<constant value="n"/>
		<constant value="J.resolveTemp(JJ):J"/>
		<constant value="transitions"/>
		<constant value="9:18-9:28"/>
		<constant value="9:41-9:56"/>
		<constant value="9:41-9:71"/>
		<constant value="9:41-9:80"/>
		<constant value="9:82-9:85"/>
		<constant value="9:18-9:86"/>
		<constant value="12:3-12:6"/>
		<constant value="12:22-12:23"/>
		<constant value="12:3-12:24"/>
		<constant value="11:2-13:3"/>
		<constant value="net"/>
		<constant value="s"/>
		<constant value="__matchProcess2Net"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="p"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="Net"/>
		<constant value="PN"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="18:5-20:3"/>
		<constant value="__applyProcess2Net"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="tasks"/>
		<constant value="places"/>
		<constant value="19:13-19:14"/>
		<constant value="19:13-19:20"/>
		<constant value="19:3-19:20"/>
		<constant value="link"/>
		<constant value="__matchTask2Place"/>
		<constant value="Task"/>
		<constant value="t"/>
		<constant value="Place"/>
		<constant value="25:5-28:3"/>
		<constant value="__applyTask2Place"/>
		<constant value="J.oclIsKindOf(J):J"/>
		<constant value="25"/>
		<constant value="0"/>
		<constant value="26"/>
		<constant value="tokens"/>
		<constant value="26:11-26:12"/>
		<constant value="26:11-26:17"/>
		<constant value="26:3-26:17"/>
		<constant value="27:16-27:17"/>
		<constant value="27:30-27:42"/>
		<constant value="27:16-27:43"/>
		<constant value="27:56-27:57"/>
		<constant value="27:49-27:50"/>
		<constant value="27:13-27:63"/>
		<constant value="27:3-27:63"/>
		<constant value="__matchnext2Transition"/>
		<constant value="next"/>
		<constant value="J.includes(J):J"/>
		<constant value="B.not():B"/>
		<constant value="44"/>
		<constant value="t1"/>
		<constant value="t2"/>
		<constant value="tr"/>
		<constant value="Transition"/>
		<constant value="33:25-33:27"/>
		<constant value="33:25-33:32"/>
		<constant value="33:43-33:45"/>
		<constant value="33:25-33:46"/>
		<constant value="34:5-37:3"/>
		<constant value="__applynext2Transition"/>
		<constant value="4"/>
		<constant value="inps"/>
		<constant value="outs"/>
		<constant value="J.addTransitions(J):J"/>
		<constant value="35:11-35:13"/>
		<constant value="35:3-35:13"/>
		<constant value="36:11-36:13"/>
		<constant value="36:3-36:13"/>
		<constant value="39:5-39:15"/>
		<constant value="39:31-39:33"/>
		<constant value="39:5-39:35"/>
		<constant value="38:2-40:3"/>
	</cp>
	<field name="1" type="2"/>
	<field name="3" type="4"/>
	<operation name="5">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<push arg="7"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="9"/>
			<pcall arg="10"/>
			<dup/>
			<push arg="11"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="12"/>
			<pcall arg="10"/>
			<pcall arg="13"/>
			<set arg="3"/>
			<getasm/>
			<push arg="14"/>
			<push arg="8"/>
			<new/>
			<set arg="1"/>
			<getasm/>
			<pcall arg="15"/>
			<getasm/>
			<pcall arg="16"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="24"/>
		</localvariabletable>
	</operation>
	<operation name="18">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<load arg="19"/>
			<getasm/>
			<get arg="3"/>
			<call arg="20"/>
			<if arg="21"/>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<dup/>
			<call arg="23"/>
			<if arg="24"/>
			<load arg="19"/>
			<call arg="25"/>
			<goto arg="26"/>
			<pop/>
			<load arg="19"/>
			<goto arg="27"/>
			<push arg="28"/>
			<push arg="8"/>
			<new/>
			<load arg="19"/>
			<iterate/>
			<store arg="29"/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<call arg="31"/>
			<enditerate/>
			<call arg="32"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="33" begin="23" end="27"/>
			<lve slot="0" name="17" begin="0" end="29"/>
			<lve slot="1" name="34" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="35">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
			<parameter name="29" type="36"/>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<load arg="19"/>
			<call arg="22"/>
			<load arg="19"/>
			<load arg="29"/>
			<call arg="37"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="6"/>
			<lve slot="1" name="34" begin="0" end="6"/>
			<lve slot="2" name="38" begin="0" end="6"/>
		</localvariabletable>
	</operation>
	<operation name="39">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<pcall arg="40"/>
			<getasm/>
			<pcall arg="41"/>
			<getasm/>
			<pcall arg="42"/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="5"/>
		</localvariabletable>
	</operation>
	<operation name="43">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="44"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="46"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="47"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="48"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="49"/>
			<call arg="45"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="50"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="1" name="33" begin="25" end="28"/>
			<lve slot="0" name="17" begin="0" end="29"/>
		</localvariabletable>
	</operation>
	<operation name="51">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="4"/>
		</parameters>
		<code>
			<getasm/>
			<push arg="52"/>
			<push arg="52"/>
			<findme/>
			<call arg="53"/>
			<call arg="54"/>
			<push arg="55"/>
			<call arg="56"/>
			<store arg="29"/>
			<load arg="29"/>
			<load arg="19"/>
			<set arg="57"/>
		</code>
		<linenumbertable>
			<lne id="58" begin="0" end="0"/>
			<lne id="59" begin="1" end="3"/>
			<lne id="60" begin="1" end="4"/>
			<lne id="61" begin="1" end="5"/>
			<lne id="62" begin="6" end="6"/>
			<lne id="63" begin="0" end="7"/>
			<lne id="64" begin="9" end="9"/>
			<lne id="65" begin="10" end="10"/>
			<lne id="66" begin="9" end="11"/>
			<lne id="67" begin="9" end="11"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="2" name="68" begin="8" end="11"/>
			<lve slot="0" name="17" begin="0" end="11"/>
			<lve slot="1" name="69" begin="0" end="11"/>
		</localvariabletable>
	</operation>
	<operation name="70">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="52"/>
			<push arg="52"/>
			<findme/>
			<push arg="71"/>
			<call arg="72"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="73"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="44"/>
			<pcall arg="74"/>
			<dup/>
			<push arg="75"/>
			<load arg="19"/>
			<pcall arg="76"/>
			<dup/>
			<push arg="55"/>
			<push arg="77"/>
			<push arg="78"/>
			<new/>
			<pcall arg="79"/>
			<pusht/>
			<pcall arg="80"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="81" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="75" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="82">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="83"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="75"/>
			<call arg="84"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="55"/>
			<call arg="85"/>
			<store arg="86"/>
			<load arg="86"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="87"/>
			<call arg="30"/>
			<set arg="88"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="89" begin="11" end="11"/>
			<lne id="90" begin="11" end="12"/>
			<lne id="91" begin="9" end="14"/>
			<lne id="81" begin="8" end="15"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="55" begin="7" end="15"/>
			<lve slot="2" name="75" begin="3" end="15"/>
			<lve slot="0" name="17" begin="0" end="15"/>
			<lve slot="1" name="92" begin="0" end="15"/>
		</localvariabletable>
	</operation>
	<operation name="93">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="94"/>
			<push arg="52"/>
			<findme/>
			<push arg="71"/>
			<call arg="72"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<get arg="1"/>
			<push arg="73"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="47"/>
			<pcall arg="74"/>
			<dup/>
			<push arg="95"/>
			<load arg="19"/>
			<pcall arg="76"/>
			<dup/>
			<push arg="75"/>
			<push arg="96"/>
			<push arg="78"/>
			<new/>
			<pcall arg="79"/>
			<pusht/>
			<pcall arg="80"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="97" begin="19" end="24"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="95" begin="6" end="26"/>
			<lve slot="0" name="17" begin="0" end="27"/>
		</localvariabletable>
	</operation>
	<operation name="98">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="83"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="95"/>
			<call arg="84"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="75"/>
			<call arg="85"/>
			<store arg="86"/>
			<load arg="86"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<get arg="38"/>
			<call arg="30"/>
			<set arg="38"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<push arg="94"/>
			<push arg="52"/>
			<findme/>
			<call arg="99"/>
			<if arg="100"/>
			<pushi arg="101"/>
			<goto arg="102"/>
			<pushi arg="19"/>
			<call arg="30"/>
			<set arg="103"/>
			<pop/>
		</code>
		<linenumbertable>
			<lne id="104" begin="11" end="11"/>
			<lne id="105" begin="11" end="12"/>
			<lne id="106" begin="9" end="14"/>
			<lne id="107" begin="17" end="17"/>
			<lne id="108" begin="18" end="20"/>
			<lne id="109" begin="17" end="21"/>
			<lne id="110" begin="23" end="23"/>
			<lne id="111" begin="25" end="25"/>
			<lne id="112" begin="17" end="25"/>
			<lne id="113" begin="15" end="27"/>
			<lne id="97" begin="8" end="28"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="75" begin="7" end="28"/>
			<lve slot="2" name="95" begin="3" end="28"/>
			<lve slot="0" name="17" begin="0" end="28"/>
			<lve slot="1" name="92" begin="0" end="28"/>
		</localvariabletable>
	</operation>
	<operation name="114">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="94"/>
			<push arg="52"/>
			<findme/>
			<push arg="71"/>
			<call arg="72"/>
			<iterate/>
			<store arg="19"/>
			<push arg="94"/>
			<push arg="52"/>
			<findme/>
			<push arg="71"/>
			<call arg="72"/>
			<iterate/>
			<store arg="29"/>
			<load arg="19"/>
			<get arg="115"/>
			<load arg="29"/>
			<call arg="116"/>
			<call arg="117"/>
			<if arg="118"/>
			<getasm/>
			<get arg="1"/>
			<push arg="73"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="49"/>
			<pcall arg="74"/>
			<dup/>
			<push arg="119"/>
			<load arg="19"/>
			<pcall arg="76"/>
			<dup/>
			<push arg="120"/>
			<load arg="29"/>
			<pcall arg="76"/>
			<dup/>
			<push arg="121"/>
			<push arg="122"/>
			<push arg="78"/>
			<new/>
			<pcall arg="79"/>
			<pusht/>
			<pcall arg="80"/>
			<enditerate/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="123" begin="14" end="14"/>
			<lne id="124" begin="14" end="15"/>
			<lne id="125" begin="16" end="16"/>
			<lne id="126" begin="14" end="17"/>
			<lne id="127" begin="36" end="41"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="119" begin="6" end="43"/>
			<lve slot="2" name="120" begin="13" end="44"/>
			<lve slot="0" name="17" begin="0" end="45"/>
		</localvariabletable>
	</operation>
	<operation name="128">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="83"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="119"/>
			<call arg="84"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="120"/>
			<call arg="84"/>
			<store arg="86"/>
			<load arg="19"/>
			<push arg="121"/>
			<call arg="85"/>
			<store arg="129"/>
			<load arg="129"/>
			<dup/>
			<getasm/>
			<load arg="29"/>
			<call arg="30"/>
			<set arg="130"/>
			<dup/>
			<getasm/>
			<load arg="86"/>
			<call arg="30"/>
			<set arg="131"/>
			<pop/>
			<getasm/>
			<load arg="129"/>
			<pcall arg="132"/>
		</code>
		<linenumbertable>
			<lne id="133" begin="15" end="15"/>
			<lne id="134" begin="13" end="17"/>
			<lne id="135" begin="20" end="20"/>
			<lne id="136" begin="18" end="22"/>
			<lne id="127" begin="12" end="23"/>
			<lne id="137" begin="24" end="24"/>
			<lne id="138" begin="25" end="25"/>
			<lne id="139" begin="24" end="26"/>
			<lne id="140" begin="24" end="26"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="4" name="121" begin="11" end="26"/>
			<lve slot="2" name="119" begin="3" end="26"/>
			<lve slot="3" name="120" begin="7" end="26"/>
			<lve slot="0" name="17" begin="0" end="26"/>
			<lve slot="1" name="92" begin="0" end="26"/>
		</localvariabletable>
	</operation>
</asm>
