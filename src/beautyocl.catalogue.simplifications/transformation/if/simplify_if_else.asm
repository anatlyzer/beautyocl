<?xml version = '1.0' encoding = 'ISO-8859-1' ?>
<asm version="1.0" name="0">
	<cp>
		<constant value="simplify_if_else"/>
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
		<constant value="A.__matchremoveIfThen():V"/>
		<constant value="A.__matchremoveIfElse():V"/>
		<constant value="__exec__"/>
		<constant value="removeIfThen"/>
		<constant value="NTransientLinkSet;.getLinksByRule(S):QNTransientLink;"/>
		<constant value="A.__applyremoveIfThen(NTransientLink;):V"/>
		<constant value="removeIfElse"/>
		<constant value="A.__applyremoveIfElse(NTransientLink;):V"/>
		<constant value="isTrue"/>
		<constant value="MOCL!BooleanExp;"/>
		<constant value="0"/>
		<constant value="booleanSymbol"/>
		<constant value="9:60-9:64"/>
		<constant value="9:60-9:78"/>
		<constant value="MOCL!OclExpression;"/>
		<constant value="10:60-10:65"/>
		<constant value="isFalse"/>
		<constant value="12:61-12:65"/>
		<constant value="12:61-12:79"/>
		<constant value="13:61-13:66"/>
		<constant value="__matchremoveIfThen"/>
		<constant value="IfExp"/>
		<constant value="OCL"/>
		<constant value="IN"/>
		<constant value="MMOF!Classifier;.allInstancesFrom(S):QJ"/>
		<constant value="condition"/>
		<constant value="J.isTrue():J"/>
		<constant value="B.not():B"/>
		<constant value="32"/>
		<constant value="TransientLink"/>
		<constant value="NTransientLink;.setRule(MATL!Rule;):V"/>
		<constant value="o"/>
		<constant value="NTransientLink;.addSourceElement(SJ):V"/>
		<constant value="a"/>
		<constant value="DeleteMoveChildren"/>
		<constant value="ACT"/>
		<constant value="NTransientLink;.addTargetElement(SJ):V"/>
		<constant value="NTransientLinkSet;.addLink2(NTransientLink;B):V"/>
		<constant value="17:3-17:4"/>
		<constant value="17:3-17:14"/>
		<constant value="17:3-17:23"/>
		<constant value="19:5-19:31"/>
		<constant value="__applyremoveIfThen"/>
		<constant value="NTransientLink;"/>
		<constant value="NTransientLink;.getSourceElement(S):J"/>
		<constant value="NTransientLink;.getTargetElement(S):J"/>
		<constant value="3"/>
		<constant value="source"/>
		<constant value="thenExpression"/>
		<constant value="children"/>
		<constant value="21:3-21:4"/>
		<constant value="21:15-21:16"/>
		<constant value="21:3-21:17"/>
		<constant value="22:3-22:4"/>
		<constant value="22:17-22:18"/>
		<constant value="22:17-22:33"/>
		<constant value="22:3-22:34"/>
		<constant value="20:2-23:3"/>
		<constant value="link"/>
		<constant value="__matchremoveIfElse"/>
		<constant value="J.isFalse():J"/>
		<constant value="28:3-28:4"/>
		<constant value="28:3-28:14"/>
		<constant value="28:3-28:24"/>
		<constant value="30:5-30:31"/>
		<constant value="__applyremoveIfElse"/>
		<constant value="elseExpression"/>
		<constant value="32:3-32:4"/>
		<constant value="32:15-32:16"/>
		<constant value="32:3-32:17"/>
		<constant value="33:3-33:4"/>
		<constant value="33:17-33:18"/>
		<constant value="33:17-33:33"/>
		<constant value="33:3-33:34"/>
		<constant value="31:2-34:3"/>
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
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="3"/>
		</localvariabletable>
	</operation>
	<operation name="42">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<getasm/>
			<get arg="1"/>
			<push arg="43"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="45"/>
			<enditerate/>
			<getasm/>
			<get arg="1"/>
			<push arg="46"/>
			<call arg="44"/>
			<iterate/>
			<store arg="19"/>
			<getasm/>
			<load arg="19"/>
			<pcall arg="47"/>
			<enditerate/>
		</code>
		<linenumbertable>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="33" begin="5" end="8"/>
			<lve slot="1" name="33" begin="15" end="18"/>
			<lve slot="0" name="17" begin="0" end="19"/>
		</localvariabletable>
	</operation>
	<operation name="48">
		<context type="49"/>
		<parameters>
		</parameters>
		<code>
			<load arg="50"/>
			<get arg="51"/>
		</code>
		<linenumbertable>
			<lne id="52" begin="0" end="0"/>
			<lne id="53" begin="0" end="1"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="48">
		<context type="54"/>
		<parameters>
		</parameters>
		<code>
			<pushf/>
		</code>
		<linenumbertable>
			<lne id="55" begin="0" end="0"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="0"/>
		</localvariabletable>
	</operation>
	<operation name="56">
		<context type="49"/>
		<parameters>
		</parameters>
		<code>
			<load arg="50"/>
			<get arg="51"/>
		</code>
		<linenumbertable>
			<lne id="57" begin="0" end="0"/>
			<lne id="58" begin="0" end="1"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="1"/>
		</localvariabletable>
	</operation>
	<operation name="56">
		<context type="54"/>
		<parameters>
		</parameters>
		<code>
			<pushf/>
		</code>
		<linenumbertable>
			<lne id="59" begin="0" end="0"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="0" name="17" begin="0" end="0"/>
		</localvariabletable>
	</operation>
	<operation name="60">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="61"/>
			<push arg="62"/>
			<findme/>
			<push arg="63"/>
			<call arg="64"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="65"/>
			<call arg="66"/>
			<call arg="67"/>
			<if arg="68"/>
			<getasm/>
			<get arg="1"/>
			<push arg="69"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="43"/>
			<pcall arg="70"/>
			<dup/>
			<push arg="71"/>
			<load arg="19"/>
			<pcall arg="72"/>
			<dup/>
			<push arg="73"/>
			<push arg="74"/>
			<push arg="75"/>
			<new/>
			<pcall arg="76"/>
			<pusht/>
			<pcall arg="77"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="78" begin="7" end="7"/>
			<lne id="79" begin="7" end="8"/>
			<lne id="80" begin="7" end="9"/>
			<lne id="81" begin="24" end="29"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="71" begin="6" end="31"/>
			<lve slot="0" name="17" begin="0" end="32"/>
		</localvariabletable>
	</operation>
	<operation name="82">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="83"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="71"/>
			<call arg="84"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="73"/>
			<call arg="85"/>
			<store arg="86"/>
			<load arg="86"/>
			<pop/>
			<load arg="86"/>
			<load arg="29"/>
			<set arg="87"/>
			<load arg="86"/>
			<load arg="29"/>
			<get arg="88"/>
			<set arg="89"/>
		</code>
		<linenumbertable>
			<lne id="81" begin="8" end="9"/>
			<lne id="90" begin="10" end="10"/>
			<lne id="91" begin="11" end="11"/>
			<lne id="92" begin="10" end="12"/>
			<lne id="93" begin="13" end="13"/>
			<lne id="94" begin="14" end="14"/>
			<lne id="95" begin="14" end="15"/>
			<lne id="96" begin="13" end="16"/>
			<lne id="97" begin="10" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="73" begin="7" end="16"/>
			<lve slot="2" name="71" begin="3" end="16"/>
			<lve slot="0" name="17" begin="0" end="16"/>
			<lve slot="1" name="98" begin="0" end="16"/>
		</localvariabletable>
	</operation>
	<operation name="99">
		<context type="6"/>
		<parameters>
		</parameters>
		<code>
			<push arg="61"/>
			<push arg="62"/>
			<findme/>
			<push arg="63"/>
			<call arg="64"/>
			<iterate/>
			<store arg="19"/>
			<load arg="19"/>
			<get arg="65"/>
			<call arg="100"/>
			<call arg="67"/>
			<if arg="68"/>
			<getasm/>
			<get arg="1"/>
			<push arg="69"/>
			<push arg="8"/>
			<new/>
			<dup/>
			<push arg="46"/>
			<pcall arg="70"/>
			<dup/>
			<push arg="71"/>
			<load arg="19"/>
			<pcall arg="72"/>
			<dup/>
			<push arg="73"/>
			<push arg="74"/>
			<push arg="75"/>
			<new/>
			<pcall arg="76"/>
			<pusht/>
			<pcall arg="77"/>
			<enditerate/>
		</code>
		<linenumbertable>
			<lne id="101" begin="7" end="7"/>
			<lne id="102" begin="7" end="8"/>
			<lne id="103" begin="7" end="9"/>
			<lne id="104" begin="24" end="29"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="1" name="71" begin="6" end="31"/>
			<lve slot="0" name="17" begin="0" end="32"/>
		</localvariabletable>
	</operation>
	<operation name="105">
		<context type="6"/>
		<parameters>
			<parameter name="19" type="83"/>
		</parameters>
		<code>
			<load arg="19"/>
			<push arg="71"/>
			<call arg="84"/>
			<store arg="29"/>
			<load arg="19"/>
			<push arg="73"/>
			<call arg="85"/>
			<store arg="86"/>
			<load arg="86"/>
			<pop/>
			<load arg="86"/>
			<load arg="29"/>
			<set arg="87"/>
			<load arg="86"/>
			<load arg="29"/>
			<get arg="106"/>
			<set arg="89"/>
		</code>
		<linenumbertable>
			<lne id="104" begin="8" end="9"/>
			<lne id="107" begin="10" end="10"/>
			<lne id="108" begin="11" end="11"/>
			<lne id="109" begin="10" end="12"/>
			<lne id="110" begin="13" end="13"/>
			<lne id="111" begin="14" end="14"/>
			<lne id="112" begin="14" end="15"/>
			<lne id="113" begin="13" end="16"/>
			<lne id="114" begin="10" end="16"/>
		</linenumbertable>
		<localvariabletable>
			<lve slot="3" name="73" begin="7" end="16"/>
			<lve slot="2" name="71" begin="3" end="16"/>
			<lve slot="0" name="17" begin="0" end="16"/>
			<lve slot="1" name="98" begin="0" end="16"/>
		</localvariabletable>
	</operation>
</asm>
